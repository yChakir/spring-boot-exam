package org.cigma.ychakir.springbootexam.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.cigma.ychakir.springbootexam.event.InvoiceEvent;
import org.cigma.ychakir.springbootexam.model.Article;
import org.cigma.ychakir.springbootexam.model.Order;
import org.cigma.ychakir.springbootexam.model.OrderStatus;
import org.cigma.ychakir.springbootexam.model.User;
import org.cigma.ychakir.springbootexam.repository.OrderRepository;
import org.cigma.ychakir.springbootexam.service.ArticleService;
import org.cigma.ychakir.springbootexam.service.OrderService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  private final ArticleService articleService;

  private final ApplicationEventPublisher publisher;

  @Override
  public Order addToCart(Order order) {
    order.setStatus(OrderStatus.IN_CART);

    return orderRepository.save(order);
  }

  @Override
  public Optional<Order> findArticleInCart(Long articleId) {
    return orderRepository.findFirstByArticleIdAndStatusIn(articleId, List.of(OrderStatus.SOLD_OUT, OrderStatus.IN_CART));
  }

  @Override
  public boolean existsByArticleId(Long articleId) {
    return orderRepository.existsByArticleId(articleId);
  }

  @Override
  public List<Order> findInCart(Long userId) {
    return orderRepository.findAllByUserIdAndStatusIn(userId, List.of(OrderStatus.SOLD_OUT, OrderStatus.IN_CART));
  }

  @Override
  public void deleteById(Long id) {
    orderRepository.deleteById(id);
  }

  @Override
  public boolean buy(User user) {
    boolean result = true;

    final List<Order> cart = findInCart(user.getId());

    for (Order order : cart) {
      final Article article = order.getArticle();
      if (article.getQuantity() < order.getQuantity()) {
        result = false;
        order.setStatus(OrderStatus.SOLD_OUT);
        orderRepository.save(order);
      } else {
        order.setStatus(OrderStatus.BILLED);
        article.setQuantity(article.getQuantity() - order.getQuantity());
      }
    }

    if (result) {
      articleService.saveAll(cart.stream().map(Order::getArticle).collect(Collectors.toList()));
      orderRepository.saveAll(cart);
      publisher.publishEvent(new InvoiceEvent(user, cart));
    }

    return result;
  }
}

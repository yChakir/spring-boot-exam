package org.cigma.springbootexam.service;

import java.util.List;
import java.util.Optional;
import org.cigma.springbootexam.model.Order;
import org.cigma.springbootexam.model.User;

public interface OrderService {

  Order addToCart(Order order);

  Optional<Order> findArticleInCart(Long articleId);

  boolean existsByArticleId(Long articleId);

  List<Order> findInCart(Long userId);

  void deleteById(Long id);

  boolean buy(User user);
}

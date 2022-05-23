package org.cigma.springbootexam.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.cigma.springbootexam.model.Article;
import org.cigma.springbootexam.model.Order;
import org.cigma.springbootexam.model.User;
import org.cigma.springbootexam.service.ArticleService;
import org.cigma.springbootexam.service.OrderService;
import org.cigma.springbootexam.service.UserService;
import org.cigma.springbootexam.vo.OrderVo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  private final UserService userService;

  private final ModelMapper modelMapper;

  private final ArticleService articleService;

  @GetMapping("cart")
  public String cart(Model model, Principal principal) {
    final Optional<User> optionalUser = userService.findByUsername(principal.getName());

    optionalUser.ifPresent(user -> {
      final List<Order> orders = orderService.findInCart(user.getId());

      final List<OrderVo> orderVos = orders.stream().map(order -> modelMapper.map(order, OrderVo.class)).collect(Collectors.toList());

      model.addAttribute("orders", orderVos);
    });

    return "orders/cart";
  }

  @PostMapping("add-to-cart/{articleId}")
  public String addToCart(@PathVariable Long articleId, @ModelAttribute("order") @Valid OrderVo orderVo, BindingResult result, Principal principal,
      RedirectAttributes attributes) {
    Order order = modelMapper.map(orderVo, Order.class);

    final Optional<Order> inCart = orderService.findArticleInCart(articleId);
    if (inCart.isPresent()) {
      inCart.get().setQuantity(inCart.get().getQuantity() + order.getQuantity());
      order = inCart.get();
    }

    final Article article = articleService.findById(articleId);
    order.setArticle(article);

    if (article.getQuantity() < order.getQuantity()) {
      result.rejectValue("quantity", null, "Quantité insuffisante");
    }

    if (result.hasErrors()) {
      attributes.addFlashAttribute("org.springframework.validation.BindingResult.order", result);
      attributes.addFlashAttribute("order", orderVo);

      return "redirect:/articles/" + articleId;
    }

    final Optional<User> optionalUser = userService.findByUsername(principal.getName());

    optionalUser.ifPresent(order::setUser);

    orderService.addToCart(order);

    return "redirect:/articles/" + articleId + "?success";
  }

  @DeleteMapping("{id}")
  public String delete(@PathVariable Long id) {
    orderService.deleteById(id);
    return "redirect:/orders/cart?deleted";
  }

  @GetMapping("buy")
  public String buy(Principal principal) {
    final Optional<User> optionalUser = userService.findByUsername(principal.getName());

    if (optionalUser.isPresent()) {
      final User user = optionalUser.get();

      final boolean buy = orderService.buy(user);

      if (!buy) {
        return "redirect:/orders/cart?failure";
      }
    }

    return "redirect:/orders/cart?success";
  }

}

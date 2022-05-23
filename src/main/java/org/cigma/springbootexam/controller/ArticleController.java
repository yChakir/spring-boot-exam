package org.cigma.springbootexam.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.cigma.springbootexam.model.Article;
import org.cigma.springbootexam.service.ArticleService;
import org.cigma.springbootexam.service.OrderService;
import org.cigma.springbootexam.vo.ArticleVo;
import org.cigma.springbootexam.vo.OrderVo;
import org.cigma.springbootexam.vo.SearchVo;
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
@RequestMapping("articles")
@RequiredArgsConstructor
public class ArticleController {

  private final ArticleService articleService;

  private final OrderService orderService;

  private final ModelMapper modelMapper;

  @ModelAttribute("article")
  public ArticleVo articleVo() {
    return new ArticleVo();
  }

  @ModelAttribute("search")
  public SearchVo searchVo() {
    return new SearchVo();
  }

  @ModelAttribute("order")
  public OrderVo orderVo() {
    return new OrderVo();
  }

  @GetMapping({"management", "management/{id}"})
  public String articleManagement(@PathVariable(required = false) Long id, Model model) {
    final List<ArticleVo> articles = articleService.findAll().stream()
        .map(article -> modelMapper.map(article, ArticleVo.class))
        .collect(Collectors.toList());

    model.addAttribute("articles", articles);

    if (id != null) {
      boolean getFromDB = true;

      if (model.containsAttribute("article")) {
        final ArticleVo article = (ArticleVo) model.getAttribute("article");

        getFromDB = article == null || article.getId() == null;
      }

      if (getFromDB) {
        final Article article = articleService.findById(id);
        model.addAttribute("article", modelMapper.map(article, ArticleVo.class));
      }
    }

    return "articles/management";
  }

  @GetMapping("search")
  public String search(Model model) {
    final List<ArticleVo> articles = articleService.findAll().stream()
        .map(article -> modelMapper.map(article, ArticleVo.class))
        .collect(Collectors.toList());

    model.addAttribute("articles", articles);

    return "articles/search";
  }

  @PostMapping("search")
  public String search(@ModelAttribute @Valid SearchVo searchVo, Model model) {
    List<ArticleVo> articles = articleService.search(searchVo.getContains(), searchVo.getStart(), searchVo.getEnd()).stream()
        .map(article -> modelMapper.map(article, ArticleVo.class))
        .collect(Collectors.toList());

    model.addAttribute("search", searchVo);
    model.addAttribute("articles", articles);
    return "articles/search";
  }

  @PostMapping("management/{id}")
  public String edit(@PathVariable Long id, @ModelAttribute("article") @Valid ArticleVo articleVo, BindingResult result, RedirectAttributes attributes) {
    if (result.hasErrors()) {
      attributes.addFlashAttribute("org.springframework.validation.BindingResult.article", result);
      attributes.addFlashAttribute("article", articleVo);

      return "redirect:/articles/management/" + id;
    }

    final Article article = articleService.findById(id);
    article.setTitle(articleVo.getTitle());
    article.setDescription(articleVo.getDescription());
    article.setQuantity(articleVo.getQuantity());
    article.setPrice(articleVo.getPrice());

    articleService.save(article);
    return "redirect:/articles/management?success";
  }

  @DeleteMapping("management/{id}")
  public String delete(@PathVariable Long id) {
    if (orderService.existsByArticleId(id)) {
      return "redirect:/articles/management?alreadyOrdered";
    }
    articleService.deleteById(id);
    return "redirect:/articles/management?delete";
  }

  @PostMapping("management")
  public String save(@ModelAttribute("article") @Valid ArticleVo articleVo, BindingResult result, RedirectAttributes attributes) {
    final Optional<Article> optional = articleService.findByReference(articleVo.getReference());
    if (optional.isPresent()) {
      result.rejectValue("reference", null, "Référence déjà utilisé");
    }

    if (result.hasErrors()) {
      attributes.addFlashAttribute("org.springframework.validation.BindingResult.article", result);
      attributes.addFlashAttribute("article", articleVo);

      return "redirect:/articles/management?new";
    }

    final Article article = modelMapper.map(articleVo, Article.class);
    articleService.save(article);

    return "redirect:/articles/management?success";
  }

  @GetMapping("{id}")
  public String details(@PathVariable Long id, Model model) {
    final Article article = articleService.findById(id);
    final ArticleVo result = modelMapper.map(article, ArticleVo.class);

    model.addAttribute("article", result);

    return "articles/details";
  }

}

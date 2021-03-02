package org.cigma.ychakir.springbootexam.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.cigma.ychakir.springbootexam.model.Article;
import org.cigma.ychakir.springbootexam.service.ArticleService;
import org.cigma.ychakir.springbootexam.vo.ArticleVo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

  private final ModelMapper modelMapper;

  @ModelAttribute("article")
  public ArticleVo articleVo() {
    return new ArticleVo();
  }

  @GetMapping({"article-management", "article-management/{id}"})
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

    return "article-management";
  }

  @PostMapping("article-management/{id}")
  public String edit(@PathVariable Long id, @ModelAttribute("article") @Valid ArticleVo articleVo, BindingResult result, RedirectAttributes attributes) {
    if (result.hasErrors()) {
      attributes.addFlashAttribute("org.springframework.validation.BindingResult.article", result);
      attributes.addFlashAttribute("article", articleVo);

      return "redirect:/articles/article-management/" + id;
    }

    final Article article = articleService.findById(id);
    article.setTitle(articleVo.getTitle());
    article.setPrice(articleVo.getPrice());

    articleService.save(article);
    return "redirect:/articles/article-management?success";
  }

  @GetMapping("article-management/delete/{id}")
  public String delete(@PathVariable Long id) {
    // TODO check if the article is already in cart
    articleService.deleteById(id);
    return "redirect:/articles/article-management?delete";
  }

  @PostMapping("article-management")
  public String save(@ModelAttribute("article") @Valid ArticleVo articleVo, BindingResult result, RedirectAttributes attributes) {
    final Optional<Article> optional = articleService.findByReference(articleVo.getReference());
    if (optional.isPresent()) {
      result.rejectValue("reference", null, "Référence déjà utilisé");
    }

    if (result.hasErrors()) {
      attributes.addFlashAttribute("org.springframework.validation.BindingResult.article", result);
      attributes.addFlashAttribute("article", articleVo);

      return "redirect:/articles/article-management?new";
    }

    final Article article = modelMapper.map(articleVo, Article.class);
    articleService.save(article);

    return "redirect:/articles/article-management?success";
  }

}

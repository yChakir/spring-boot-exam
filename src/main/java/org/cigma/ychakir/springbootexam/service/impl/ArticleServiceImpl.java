package org.cigma.ychakir.springbootexam.service.impl;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.cigma.ychakir.springbootexam.model.Article;
import org.cigma.ychakir.springbootexam.repository.ArticleRepository;
import org.cigma.ychakir.springbootexam.service.ArticleService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

  private final ArticleRepository articleRepository;

  @Override
  public List<Article> findAll() {
    return articleRepository.findAll();
  }

  @Override
  public Article findById(Long id) {
    return articleRepository.findById(id).orElse(null);
  }

  @Override
  public Article save(Article article) {
    return articleRepository.save(article);
  }

  @Override
  public Optional<Article> findByReference(String reference) {
    return articleRepository.findByReference(reference);
  }

  @Override
  public void deleteById(Long id) {
    articleRepository.deleteById(id);
  }
}

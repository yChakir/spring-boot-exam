package org.cigma.ychakir.springbootexam.service;

import java.util.List;
import java.util.Optional;
import org.cigma.ychakir.springbootexam.model.Article;

public interface ArticleService {

  List<Article> findAll();

  Article findById(Long id);

  Article save(Article article);

  Optional<Article> findByReference(String reference);

  void deleteById(Long id);

  List<Article> search(String contains, String start, String end);

  void saveAll(List<Article> collect);
}

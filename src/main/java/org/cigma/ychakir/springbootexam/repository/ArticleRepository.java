package org.cigma.ychakir.springbootexam.repository;

import java.util.Optional;
import org.cigma.ychakir.springbootexam.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

  Optional<Article> findByReference(String reference);
}

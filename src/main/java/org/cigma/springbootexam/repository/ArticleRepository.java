package org.cigma.springbootexam.repository;

import java.util.List;
import java.util.Optional;
import org.cigma.springbootexam.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

  Optional<Article> findByReference(String reference);

  @Query("SELECT a FROM Article a WHERE (:contains IS NOT NULL AND a.description LIKE CONCAT('%', :contains, '%')) OR "
      + "(:startWith IS NOT NULL AND a.description LIKE CONCAT(:startWith, '%')) OR "
      + "(:endWith IS NOT NULL AND a.description LIKE CONCAT('%', :endWith))")
  List<Article> search(@Param("contains") String contains, @Param("startWith") String start, @Param("endWith") String end);
}

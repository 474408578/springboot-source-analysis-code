package com.kancloud.springboot.jpa.operation.single.repository;

import com.kancloud.springboot.jpa.operation.single.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xschen
 */

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByAuthor(String author);
}

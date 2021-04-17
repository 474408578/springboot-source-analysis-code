package com.kancloud.springboot.jpa.operation.single.repository;

import com.kancloud.springboot.jpa.operation.single.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xschen
 */

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByAuthor(String author);

    /**
     * 查询 article 表所有数据，传入 Pageable 分页参数，不需要写 sql
     * @param pageable
     * @return
     */
    Page<Article> findAll(Pageable pageable);

    /**
     * 根据 author 字段 查找数据，传入 Pageable 分页参数，不需要写 sql
     * @param pageable
     * @return
     */
    Page<Article> findByAuthor(String author, Pageable pageable);

    /**
     * 根据 author 字段和 title 字段，查询数据，传入Pageable分页参数，不需要写SQL
     * @param author
     * @param title
     * @param pageable
     * @return
     */
    Page<Article> findByAuthorAndTitle(String author, String title, Pageable pageable);
}

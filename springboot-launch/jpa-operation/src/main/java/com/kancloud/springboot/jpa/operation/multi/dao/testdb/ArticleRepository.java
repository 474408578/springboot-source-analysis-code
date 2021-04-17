package com.kancloud.springboot.jpa.operation.multi.dao.testdb;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xschen
 */

public interface ArticleRepository extends JpaRepository<Article, Long> {

}

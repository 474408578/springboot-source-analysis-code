package com.kancloud.springboot.jpa.operation.multi.dao.testdb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xschen
 */

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}

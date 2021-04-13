package com.kancloud.springboot.jdbc.operation.jta.service;

import com.kancloud.springboot.jdbc.operation.jta.dao.ArticleDao;
import com.kancloud.springboot.jdbc.operation.jta.model.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author xschen
 */

@Service
public class ArticleService {

    @Resource
    private ArticleDao articleDao;

    @Resource
    private JdbcTemplate primaryJdbcTemplate;
    @Resource
    private JdbcTemplate secondaryJdbcTemplate;

    @Transactional
    public void saveArticle(Article article) {
        articleDao.save(article,primaryJdbcTemplate);
        articleDao.save(article,secondaryJdbcTemplate);

        int a =  10/0;
    }
}

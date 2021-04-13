package com.kancloud.springboot.jdbc.operation.multi.service;


import com.kancloud.springboot.jdbc.operation.multi.dao.ArticleDao;
import com.kancloud.springboot.jdbc.operation.multi.model.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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

    public void saveArticle(Article article) {
        articleDao.save(article, primaryJdbcTemplate);
        articleDao.save(article, secondaryJdbcTemplate);

        int a =  10/0;
    }
}

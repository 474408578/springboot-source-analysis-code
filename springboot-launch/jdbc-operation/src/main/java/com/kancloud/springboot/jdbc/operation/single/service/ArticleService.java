package com.kancloud.springboot.jdbc.operation.single.service;

import com.kancloud.springboot.jdbc.operation.single.dao.ArticleDao;
import com.kancloud.springboot.jdbc.operation.single.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xschen
 */

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Transactional
    public void saveArticle(Article article) {
        articleDao.save(article);
         //int a = 2 / 0; //人为制造一个异常，用于测试事务
        return ;
    }

    public void deleteArticle(Long id) {
        articleDao.deleteById(id);
    }

    public void updateArticle(Article article) {
        articleDao.updateById(article);
    }

    public Article getArticle(Long id) {
        return articleDao.findById(id);
    }

    public List<Article> getAll() {
        return articleDao.findAll();
    }
}

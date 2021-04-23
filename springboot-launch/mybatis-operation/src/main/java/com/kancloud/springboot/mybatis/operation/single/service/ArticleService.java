package com.kancloud.springboot.mybatis.operation.single.service;

import com.kancloud.springboot.mybatis.operation.single.entity.Article;
import com.kancloud.springboot.mybatis.operation.single.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xschen
 */

@Service
public class ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    public void saveArticle(Article article) {
        articleMapper.insert(article);
    }

    public void deleteArticle(Long id) {
        articleMapper.deleteById(id);
    }

    public void updateArticle(Article article) {
        articleMapper.updateById(article);
    }

    public Article getArticle(Long id) {
        Article article = articleMapper.selectById(id);
        return article;
    }

    public List<Article> getAll() {
        List<Article> articles = articleMapper.selectList(null);
        return articles;
    }
}

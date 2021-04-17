package com.kancloud.springboot.jpa.operation.single.service;

import com.kancloud.springboot.jpa.operation.single.entity.Article;
import com.kancloud.springboot.jpa.operation.single.model.Reader;
import com.kancloud.springboot.jpa.operation.single.repository.ArticleRepository;
import com.kancloud.springboot.jpa.operation.single.vo.ArticleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xschen
 */

@Service
public class ArticleService {

    @Resource
    private ArticleRepository articleRepository;

    public ArticleVO saveArticle(ArticleVO articleVO) {
        Article article = new Article();
        BeanUtils.copyProperties(articleVO, article);
        articleRepository.save(article);
        return articleVO;
    }

    public void saveArticle(Article article) {
        articleRepository.save(article);
    }


    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    public void updateArticle(ArticleVO articleVO) {
        Article article = new Article();
        BeanUtils.copyProperties(articleVO, article);
        articleRepository.save(article);
    }

    public ArticleVO getArticle(Long id) {
        Article article = articleRepository.getOne(id);
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(article, articleVO);
        List<Reader> readerList = new ArrayList<>();
        readerList.add(new Reader("song", 24));
        readerList.add(new Reader("hui", 27));
        articleVO.setReaderList(readerList);
        return articleVO;
    }

    public List<Article> getAllArticle() {
        List<Article> articles = articleRepository.findAll();
        return articles;
    }

    /**
     * 指定排序方式，查询所有数据
     * @param sort
     * @return
     */
    public List<Article> getAllArticle(Sort sort) {
        List<Article> articles = articleRepository.findAll(sort);
        return articles;
    }

    public ArticleVO findByAuthor(String author) {
        Article song = articleRepository.findByAuthor("song");
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(song, articleVO);
        List<Reader> readerList = new ArrayList<>();
        readerList.add(new Reader("song", 24));
        readerList.add(new Reader("hui", 27));
        articleVO.setReaderList(readerList);
        return articleVO;
    }

    public Page<Article> getAllArticle(Pageable pageable) {
        Page<Article> articles = articleRepository.findAll(pageable);
        return articles;
    }
}

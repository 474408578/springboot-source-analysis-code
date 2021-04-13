package com.kancloud.springboot.jdbc.operation.single.controller;

import com.kancloud.springboot.launch.core.utils.result.ListResult;
import com.kancloud.springboot.launch.core.utils.result.ListResultUtil;
import com.kancloud.springboot.launch.core.utils.result.Result;
import com.kancloud.springboot.launch.core.utils.result.ResultUtil;
import com.kancloud.springboot.jdbc.operation.single.model.Article;
import com.kancloud.springboot.jdbc.operation.single.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xschen
 */

@RestController
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/articles/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<Article> getArticle(@PathVariable("id") Long id) {
        Article article = articleService.getArticle(id);
        log.info("article: " + article);
        return ResultUtil.success(article);
    }


    @RequestMapping(value = "/articles",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<Article> saveArticle(@RequestBody Article article) {
        articleService.saveArticle(article);
        log.info("saveArticle:" + article);
        return ResultUtil.success(article);
    }


    @PutMapping("/articles")
    public Result updateArticle(@RequestBody Article article){
        articleService.updateArticle(article);

        log.info("updateArticle:" + article);
        return ResultUtil.success();
    }

    @DeleteMapping("/articles/{id}")
    public Result deleteArticle(@PathVariable("id") Long id){

        articleService.deleteArticle(id);
        log.info("deleteArticle:" + id);
        return ResultUtil.success();
    }

    @GetMapping("/articles")
    public ListResult<Article> getArticles() {
        List<Article> articles = articleService.getAll();
        log.info("articles: " + articles);
        return ListResultUtil.success(articles);
    }
}

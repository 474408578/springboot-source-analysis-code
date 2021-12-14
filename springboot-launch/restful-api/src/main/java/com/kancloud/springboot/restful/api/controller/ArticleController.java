package com.kancloud.springboot.restful.api.controller;

import com.kancloud.springboot.launch.core.utils.result.Result;
import com.kancloud.springboot.launch.core.utils.result.ResultUtil;
import com.kancloud.springboot.restful.api.model.Article;
import com.kancloud.springboot.restful.api.model.Reader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author xschen
 */

@RestController
@Slf4j
public class ArticleController {

    @RequestMapping(value = "/articles/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<Article> getArticle(@PathVariable("id") Long id) {
        Reader song = Reader.builder().name("song").age(23).build();
        Article article = Article.builder()
                .id(1L)
                .author("song")
                .content("spring boot content")
                .title("spring boot")
                .createTime(LocalDateTime.now())
                .reader(Arrays.asList(song))
                .build();

        log.info("article: " + article);
        return ResultUtil.success(article);
    }


    @RequestMapping(value = "/articles",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<Article> saveArticle(@RequestBody Article article) {
        log.info("saveArticle:" + article);
        return ResultUtil.success(article);
    }


    @PutMapping("/articles")
    public Result updateArticle(@RequestBody Article article){
        if(article.getId() == null){
            //TODO 抛出一个自定义的异常
        }

        log.info("updateArticle:" + article);
        return ResultUtil.success();
    }

    @DeleteMapping("/articles/{id}")
    public Result deleteArticle(@PathVariable("id") Long id){

        log.info("deleteArticle:" + id);
        return ResultUtil.success();
    }

}

package com.kancloud.springboot.jpa.operation.single.controller;

import com.kancloud.springboot.jpa.operation.single.entity.Article;
import com.kancloud.springboot.jpa.operation.single.service.ArticleService;
import com.kancloud.springboot.launch.core.utils.result.Result;
import com.kancloud.springboot.launch.core.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xschen
 */

@RestController
public class ArticleController {


    @Autowired
    private ArticleService articleService;


    @GetMapping("articles")
    public Result<Page<Article>> getAllArticle() {
        //Pageable pageable = PageRequest.of(0, 10); // 第一页
        //Pageable pageable = PageRequest.of(1, 10); // 第二页
        // 先排序好再分页
        Pageable pageable = PageRequest.of(1, 10, Sort.by("createTime").descending());
        Page<Article> allArticle = articleService.getAllArticle(pageable);
        return ResultUtil.success(allArticle);
    }

    @GetMapping("/articles/sort")
    public Result<List<Article>> getAllArticleBySort(@RequestParam("name") String name,
                                                     @RequestParam("isAsc") Boolean isAsc) {
        Sort sort;
        if (isAsc == true) {
           sort = Sort.by(name);
        } else {
            sort = Sort.by(name).descending();
        }
        List<Article> articles = articleService.getAllArticle(sort);
        return ResultUtil.success(articles);
    }



}

package com.kancloud.springboot.mybatis.operation.single;

import com.kancloud.springboot.mybatis.operation.single.entity.Article;
import com.kancloud.springboot.mybatis.operation.single.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author xschen
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MybatisApplicationTest {
    @Resource
    private ArticleService articleService;

    @Test
    public void ArticleServiceTest() {
        Article article = Article.builder().author("song").title("spring").content("spring content").createTime(LocalDateTime.now()).build();
        articleService.saveArticle(article);
    }

}

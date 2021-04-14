package com.kancloud.springboot.jpa.operation.single;

import com.kancloud.springboot.jpa.operation.single.service.ArticleService;
import com.kancloud.springboot.jpa.operation.single.vo.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author xschen
 */

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class JpaApplicationTest {

    @Resource
    private ArticleService articleService;

    @Test
    public void testArticleService() {
        ArticleVO article = new ArticleVO();
        article.setAuthor("song");
        article.setTitle("spring");
        article.setContent("spring content");
        article.setCreateTime(LocalDateTime.now());
        // 保存
        articleService.saveArticle(article);
        // 查找所有
        log.info("{}", articleService.getAllArticle());
        // 根据 author 查找
        ArticleVO song = articleService.findByAuthor("song");
        log.info("{}", song);

        // 更新
        song.setAuthor("xiaosong");
        articleService.updateArticle(song);
    }

}

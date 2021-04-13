package com.kancloud.springboot.jdbc.operation.jta;

import com.kancloud.springboot.jdbc.operation.jta.dao.ArticleDao;
import com.kancloud.springboot.jdbc.operation.jta.service.ArticleService;
import com.kancloud.springboot.jdbc.operation.jta.model.Article;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author xschen
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SpringJdbcTest {

    @Resource
    private ArticleDao articleDao;

    @Resource //  默认按照名称来进行装配
    private JdbcTemplate primaryJdbcTemplate;

    @Resource
    private JdbcTemplate secondaryJdbcTemplate;

    @Resource
    private ArticleService articleService;

    @Test
    @Transactional
    public void testJdbc() {
        articleDao.save(Article.builder()
                .author("song-multi-1")
                .title("spring boot")
                .content("spring boot content")
                .createTime(LocalDateTime.now())
                .build(), primaryJdbcTemplate);


        articleDao.save(Article.builder()
                .author("song-multi-1")
                .title("spring boot")
                .content("spring boot content")
                .createTime(LocalDateTime.now())
                .build(), secondaryJdbcTemplate);
    }

    @Test
    public void testTransaction() {
        articleService.saveArticle(Article.builder()
                .author("song-multi-2")
                .title("spring boot")
                .content("spring boot content")
                .createTime(LocalDateTime.now())
                .build());
    }
}

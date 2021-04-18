package com.kancloud.springboot.jpa.operation.jta;

import com.kancloud.springboot.jpa.operation.jta.dao.testdb.Article;
import com.kancloud.springboot.jpa.operation.jta.dao.testdb.ArticleRepository;
import com.kancloud.springboot.jpa.operation.jta.dao.testdb2.Message;
import com.kancloud.springboot.jpa.operation.jta.dao.testdb2.MessageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

/**
 * @author xschen
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class JpaApplicationTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void jtaTest() {
        Article article = Article.builder().author("song").title("spring").content("spring content").createTime(LocalDateTime.now()).build();
        articleRepository.save(article);

        Message message = Message.builder().name("song").content("song").build();
        messageRepository.save(message);
    }
}

package com.kancloud.springboot.restful.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

/**
 * @author xschen
 */

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class ArticleControllerTest2 {

    @Resource
    private MockMvc mockMvc;

    @Test
    public void saveArticle() throws Exception {
        String article = "{\n" +
                "    \"id\": 1,\n" +
                "        \"author\": \"song\",\n" +
                "        \"title\": \"spring boot\",\n" +
                "        \"content\": \"spring boot content\",\n" +
                "        \"createTime\": \"2021-04-02 10:14:36\",\n" +
                "        \"reader\": [\n" +
                "            {\n" +
                "                \"name\": \"song\",\n" +
                "                \"age\": 23\n" +
                "            }\n" +
                "        ]\n" +
                "}";

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/articles")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(article)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("song"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(23))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());
    }
}

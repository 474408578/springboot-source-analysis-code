package com.kancloud.springboot.jpa.operation.single.vo;

import com.kancloud.springboot.jpa.operation.single.model.Reader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author xschen
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVO {

    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createTime;
    private List<Reader> readerList;
}

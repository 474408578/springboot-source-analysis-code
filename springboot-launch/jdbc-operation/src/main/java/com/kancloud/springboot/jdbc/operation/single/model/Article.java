package com.kancloud.springboot.jdbc.operation.single.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author xschen
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {
    private Long id;
    private String author;
    private String title;
    private String content;
    //  指定日期类型的属性格式, 体现在 JSON 数据里
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") 通常做全局配置
    private LocalDateTime createTime;

    // 为某个属性换一个名称，体现在 JSON 数据里
    private List<Reader> reader;
}

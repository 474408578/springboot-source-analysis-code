package com.kancloud.springboot.mybatis.operation.single.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author xschen
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String author;

    private String content;

    private String title;

    private LocalDateTime createTime;
}

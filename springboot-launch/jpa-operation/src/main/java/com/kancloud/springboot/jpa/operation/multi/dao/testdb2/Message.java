package com.kancloud.springboot.jpa.operation.multi.dao.testdb2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author xschen
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;
}

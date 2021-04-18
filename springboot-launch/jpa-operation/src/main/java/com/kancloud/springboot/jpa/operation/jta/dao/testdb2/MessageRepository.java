package com.kancloud.springboot.jpa.operation.jta.dao.testdb2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xschen
 */

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}

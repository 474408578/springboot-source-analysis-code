package com.kancloud.springboot.rdbms.operation;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * JDBC 操作数据库示例
 * @author xschen
 */

@Slf4j
public class JDBCDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // 触发类加载
        String url = "jdbc:mysql://localhost:3307/testdb?user=root&password=123456&useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        try (Connection connection = DriverManager.getConnection(url);
             Statement stmt = connection.createStatement()) {
            log.info("连接数据库：{} 成功", connection.toString());
            String sql = "select * from article where id = 1";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                log.info("id={}, author={}, title={}, content={}, createTime={}",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getTime(5));
            }

        } catch (SQLException throwables) {
            log.error("连接失败: {}", throwables.getMessage());
        }

    }
}

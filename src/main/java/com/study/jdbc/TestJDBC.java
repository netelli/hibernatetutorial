package com.study.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String jdbcUser = "hbstudent";
        String jdbcPass = "hbstudent";
        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);
            System.out.println("Connection successful");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

package com.kh.common;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {
    public static Connection getConnection() {
        Connection conn = null;
        Properties prop = new Properties();

        String filepath = JDBCTemplate.class.getResource("/db/driver/driver.properties").getPath();
        System.out.println(filepath);

        try {
            prop.load(new FileInputStream(filepath));

            Class.forName(prop.getProperty("driver"));

            conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
                    prop.getProperty("password"));

            conn.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(conn);
        return conn;
    }

    public static void commit(Connection conn) {
        try {
            if (conn != null & !conn.isClosed()) {
                conn.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stat) {
        try {
            if (stat != null && !stat.isClosed()) {
                stat.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void close(ResultSet rset) {
        try {
            if (rset != null && !rset.isClosed()) {
                rset.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package com.natalia.factory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
    public static void main(String[] args) throws SQLException {
        Connection connection = Factory.getConnection();
        Statement stmt = connection.createStatement();
        stmt.execute("create table users(userId int (5) PRIMARY KEY AUTO_INCREMENT, " +
                "username varchar(256), password varchar(256), " +
                "email varchar(256), role varchar (256), token varchar (50))");
        stmt.execute("create table roles (roleId int (5) PRIMARY KEY AUTO_INCREMENT, role varchar (50), " +
                "userId int (5), FOREIGN KEY (userId) REFERENCES users (userId))");
        stmt.execute("create table categories (categoryId int (5) PRIMARY KEY AUTO_INCREMENT, " +
                "categoryname varchar (256))");
        stmt.execute("create table products (productId int (5) PRIMARY KEY AUTO_INCREMENT, " +
                "productname varchar (256), price double, categoryId int (5), FOREIGN KEY (categoryId) " +
                "REFERENCES categories (categoryId))");
        connection.close();
    }
}

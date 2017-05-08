package com.natalia.dao;

import com.natalia.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User save(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String role = user.setRole("user");
        String token = user.getToken();
        try {
            PreparedStatement statement =
                    connection.prepareStatement("insert into users (username, password, email, role, token) values " +
                            "('" + username + "', '" + password + "', '" + email + "','" + role + "', '" + token + "')");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> getUsersByName(String username) {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select userId, username, email from users where username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = User.from (Integer.parseInt(resultSet.getString("userId")),
                        resultSet.getString("username"), resultSet.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public User getById(int userId) {
          User user = null;
          try {
            PreparedStatement statement = connection.prepareStatement("select userId, username, password, email, role from users where userId = ?");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String role = resultSet.getString("role");
                user = User.from(userId, username, password, email, role);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User remove (int userId){
         User user = null;
         try {
            PreparedStatement statement =
                    connection.prepareStatement("delete from users where userId = ?");
            statement.setInt(1,userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return user;
    }

    @Override
    public User update(User user) {
        int userId = user.getUserId();
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        try {
            PreparedStatement statement =
                    connection.prepareStatement("update users set username='" + username + "', password ='" + password + "', email='" + email + "' where userId = ?");
            statement.setInt(1,userId);
            statement.executeUpdate();
            user = User.from(userId, username, password, email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from users");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = User.from (Integer.parseInt(resultSet.getString("userId")),
                        resultSet.getString("username"), resultSet.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findByToken(String token) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from users where token = ?");
            statement.setString(1, token);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            String username = resultSet.getString("username");
            int userId = resultSet.getInt("userId");
            user = User.from(userId, username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}

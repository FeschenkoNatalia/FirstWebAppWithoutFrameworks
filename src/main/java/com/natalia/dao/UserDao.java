package com.natalia.dao;

import com.natalia.model.User;

import java.util.List;


public interface UserDao extends GenericDao<User>{
    User save(User user);

    List<User> getUsersByName(String username);

    User getById(int userId);

    List<User> getAllUsers();

    User remove (int userId);

    User update (User user);

    User findByToken(String token);

}

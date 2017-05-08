package com.natalia.service;

import com.natalia.model.User;

import java.util.List;

/**
 * Created by User on 18.03.2017.
 */
public interface UserService {

        User save(User user);

        User getById (int userId);

        User remove (int userId);

        User update (User user);

        List<User> getAllUsers();

}

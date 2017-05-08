package com.natalia.service;

import com.natalia.dao.UserDao;
import com.natalia.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User getById(int userId) {
        return userDao.getById(userId);
    }

    @Override
    public User remove (int userId){
        return userDao.remove(userId);
    }

    @Override
    public User update (User user){
        return userDao.update(user);
    }

    @Override
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

}

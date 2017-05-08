package com.natalia.factory;
import com.natalia.controller.*;
import com.natalia.dao.CategoryDao;
import com.natalia.dao.CategoryDaoImpl;
import com.natalia.dao.UserDao;
import com.natalia.dao.UserDaoImpl;
import com.natalia.service.CategoryService;
import com.natalia.service.CategoryServiceImpl;
import com.natalia.service.UserService;
import com.natalia.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {

    public static Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static Controller getHomeController() {
        return new HomeController();
    }

    public static Controller getSignUpController() {
        return new SignUpController();
    }

    public static Controller getErrorController (){return new ErrorController();}

    public static Controller getRegistrationController(UserService userService) {
        return new RegistrationController(userService);
    }

    public static Controller getUserGetByIdController (UserService userService){
        return new UserGetByIdController(userService);
    }

    public static Controller getAllUsersController(UserService userService) {
        return new GetAllUsersController(userService);
    }

    public static Controller getRemoveController (UserService userService){
        return new RemoveController (userService);
    }

    public static Controller getUserFormController (){return new UserFormController();}

    public static Controller getUpdateController (UserService userService){
        return new UpdateController(userService);
    }

    public static UserService getUserServiceImpl(UserDao userDao) {
        return new UserServiceImpl(userDao);
    }

    public static UserDao getUserDaoImpl(Connection connection) {
        return new UserDaoImpl(connection);
    }

    public static Controller getAllCategoriesController (CategoryService categoryService){
        return new GetAllCategoriesController(categoryService);
    }

    public static CategoryService getCategoryServiceImpl (CategoryDao categoryDao){
        return new CategoryServiceImpl(categoryDao);
    }
    public static CategoryDao getCategoryDaoImpl(Connection connection) {
        return new CategoryDaoImpl(connection);
    }
}
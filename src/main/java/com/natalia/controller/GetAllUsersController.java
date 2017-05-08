package com.natalia.controller;

import com.natalia.model.User;
import com.natalia.service.UserService;
import com.natalia.servlet.Request;
import com.natalia.view.ViewModel;

import java.util.List;


public class GetAllUsersController implements Controller {
    private final UserService userService;

    public GetAllUsersController(UserService userService) {
        this.userService = userService;
    }

    public ViewModel process (Request request) {
        List <User> users = userService.getAllUsers();
        return new ViewModel("/WEB-INF/users.jsp").withAttribute("users",users);
    }
}
package com.natalia.controller;

import com.natalia.model.User;
import com.natalia.service.UserService;
import com.natalia.servlet.Request;
import com.natalia.view.ViewModel;

import java.util.List;

public class RemoveController implements Controller {
    private final UserService userService;

    public RemoveController(UserService userService) {
        this.userService = userService;
    }

    public ViewModel process (Request request) {
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        userService.remove(userId);
        List <User> users = userService.getAllUsers();
        return new ViewModel("/WEB-INF/users.jsp").withAttribute("users",users);
    }
}

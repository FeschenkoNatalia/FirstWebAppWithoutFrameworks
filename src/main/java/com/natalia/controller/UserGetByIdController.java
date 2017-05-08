package com.natalia.controller;

import com.natalia.model.User;
import com.natalia.service.UserService;
import com.natalia.servlet.Request;
import com.natalia.view.ViewModel;


public class UserGetByIdController implements Controller {
    private final UserService userService;

    public UserGetByIdController(UserService userService) {
        this.userService = userService;
    }
    @Override
    public ViewModel process (Request request) {
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        User user = userService.getById(userId);
        return new ViewModel("/WEB-INF/user.jsp").withAttribute("user", user);
    }
}

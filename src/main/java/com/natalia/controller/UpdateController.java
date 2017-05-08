package com.natalia.controller;

import com.natalia.model.User;
import com.natalia.service.UserService;
import com.natalia.servlet.Request;
import com.natalia.view.ViewModel;

public class UpdateController implements Controller{
    private final UserService userService;

    public UpdateController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(Request request) {
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = User.from (userId,username,password,email);
        userService.update(user);
        return new ViewModel("/WEB-INF/postProcPage.jsp").withAttribute("user",user);
    }
}

package com.natalia.controller;
import com.natalia.model.User;
import com.natalia.service.UserService;
import com.natalia.servlet.Request;
import com.natalia.view.ViewModel;

public class RegistrationController implements Controller {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(Request request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = "user";
        String token = username + System.nanoTime();
        User user = User.create(username,password,email,role,token);
        userService.save(user);
        return new ViewModel("/WEB-INF/postProcPage.jsp").addCookie("token",token).withAttribute("user", user);
    }
}
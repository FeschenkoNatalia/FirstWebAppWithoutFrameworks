package com.natalia.controller;

import com.natalia.servlet.Request;
import com.natalia.view.ViewModel;

public class UserFormController implements Controller {
    public ViewModel process (Request request){
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        return new ViewModel("/WEB-INF/userform.jsp").withAttribute("userId",userId );
    }
}

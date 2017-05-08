package com.natalia.controller;

import com.natalia.servlet.Request;
import com.natalia.view.ViewModel;

public class SignUpController implements Controller {
    public ViewModel process (Request request){
        return new ViewModel("/WEB-INF/signUp.jsp");
    }
}

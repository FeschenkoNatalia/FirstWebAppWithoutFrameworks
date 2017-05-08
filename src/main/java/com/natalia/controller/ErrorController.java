package com.natalia.controller;

import com.natalia.servlet.Request;
import com.natalia.view.ViewModel;

public class ErrorController implements Controller{
    @Override
    public ViewModel process(Request request) {
        return new ViewModel("/WEB-INF/error.jsp");
    }
}

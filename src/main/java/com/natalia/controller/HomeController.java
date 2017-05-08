package com.natalia.controller;

import com.natalia.servlet.Request;
import com.natalia.view.ViewModel;

public class HomeController implements Controller {
    public ViewModel process (Request request) {
        return new ViewModel("/WEB-INF/home.jsp");
    }
}
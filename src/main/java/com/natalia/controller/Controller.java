package com.natalia.controller;

import com.natalia.servlet.Request;
import com.natalia.view.ViewModel;

public interface Controller {
    ViewModel process
          (Request request);
}

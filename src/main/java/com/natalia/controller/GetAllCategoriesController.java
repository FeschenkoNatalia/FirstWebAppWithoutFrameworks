package com.natalia.controller;

import com.natalia.model.Category;
import com.natalia.service.CategoryService;
import com.natalia.servlet.Request;
import com.natalia.view.ViewModel;

import java.util.List;

public class GetAllCategoriesController implements Controller {
    private final CategoryService categoryService;

    public GetAllCategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public ViewModel process(Request request) {
        List<Category> categories = categoryService.getAllCategories();
        return new ViewModel("/WEB-INF/categories.jsp").withAttribute("categories", categories);
    }
}

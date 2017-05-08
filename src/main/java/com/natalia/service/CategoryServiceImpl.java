package com.natalia.service;

import com.natalia.dao.CategoryDao;
import com.natalia.model.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{
    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }
}

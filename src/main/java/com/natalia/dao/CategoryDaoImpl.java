package com.natalia.dao;

import com.natalia.model.Category;
import com.natalia.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private final Connection connection;

    public CategoryDaoImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select categoryname from categories");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
               // List<Product> products = (List<Product>) resultSet.getObject(2, ArrayList.class);
               // Category category = new Category(resultSet.getString("categoryname"), products);
                Category category = Category.create(resultSet.getString("categoryname"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}

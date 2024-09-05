package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import java.util.*;
public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long CategoryId);
    Category updateCategory(Category category, Long categoryId);
}

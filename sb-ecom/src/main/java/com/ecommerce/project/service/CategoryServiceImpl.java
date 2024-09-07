package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repositories.CategoryRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
//    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
//        return categories;
        return categoryRepository.findAll();
    }


    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not Found"));
//        List<Category> categories = categoryRepository.findAll();
//        Category category = categories.stream()
//                .filter(c->c.getCategoryId().equals(categoryId))
//                .findFirst()
//                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not Found"));
//        categories.remove(category);
        categoryRepository.delete(category);
        return "Category with categoryId " + categoryId + " deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));

        category.setCategoryId(categoryId);
//        Optional<Category> optionalCategory = categories.stream()
//                .filter(c->c.getCategoryId().equals(categoryId))
//                .findFirst();
//        if(optionalCategory.isPresent()){
//            Category existingCategory = optionalCategory.get();
//            existingCategory.setCategoryName(category.getCategoryName());
//            Category savedCategory = categoryRepository.save(category);
//            return existingCategory;
//        }
//        else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categorty not Found");
//        }
        savedCategory = categoryRepository.save(category);
        return savedCategory;
    }

}
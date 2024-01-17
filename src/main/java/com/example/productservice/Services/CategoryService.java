package com.example.productservice.Services;

import com.example.productservice.Models.Category;
import com.example.productservice.Repositaries.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepo categoryRepo;
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }
    public Category updateCategory(long id, Category category) {

        Optional<Category> existingCategoryOp = categoryRepo.findById(id);
        if (existingCategoryOp.isEmpty()) {
            return null;
        }

        category.setId(id);
        return categoryRepo.save(category);
    }
    public String deleteCategory() {
        return "Category deleted";
    }
    public Category getCategory(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
}

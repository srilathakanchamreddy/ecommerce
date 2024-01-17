package com.example.productservice.Controllers;

import com.example.productservice.Commons.ApiResponse;
import com.example.productservice.DTOs.CategoryRequestDTO;
import com.example.productservice.DTOs.CategoryMapper;
import com.example.productservice.DTOs.CategoryResponseDTO;
import com.example.productservice.Exceptions.CategoryNotFoundException;
import com.example.productservice.Models.Category;
import com.example.productservice.Services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/create")
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO categoryDTO) {
        Category category= categoryService.createCategory(CategoryMapper.toEntity(categoryDTO));
        return new ResponseEntity<>(CategoryMapper.toDTO(category), HttpStatus.CREATED);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryRequestDTO categoryDTO) {
        Category category= categoryService.updateCategory(id,CategoryMapper.toEntity(categoryDTO));
        if(category==null)
            throw new CategoryNotFoundException("Category with id "+id+" not found");
        return new ResponseEntity<>(CategoryMapper.toDTO(category), HttpStatus.OK);
    }
    public String deleteCategory() {
        return "Category deleted";
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategory(@PathVariable Long id) {
        Category category= categoryService.getCategory(id);
        if(category==null)
            throw new CategoryNotFoundException("Category with id "+id+" not found");
        return new ResponseEntity<>(CategoryMapper.toDTO(category), HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        List<Category> categories= categoryService.getAllCategories();
        List<CategoryResponseDTO> response = new ArrayList<>();
        for(Category category:categories){
            response.add(CategoryMapper.toDTO(category));
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}

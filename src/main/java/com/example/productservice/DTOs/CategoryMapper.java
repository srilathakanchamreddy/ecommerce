package com.example.productservice.DTOs;

import com.example.productservice.Models.Category;

public class CategoryMapper {
    public static CategoryResponseDTO toDTO(Category category) {
        CategoryResponseDTO categoryDTO = new CategoryResponseDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setImage(category.getImage());
        return categoryDTO;
    }

    public static Category toEntity(CategoryRequestDTO categoryDTO) {
        Category category = new Category();

        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setImage(categoryDTO.getImage());
        return category;
    }
}

package com.example.productservice.DTOs;

import com.example.productservice.Models.Product;

public class ProductMapper {
    public static Product toProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setImage(productRequestDTO.getImage());
        return product;
    }

    public static ProductResponseDTO toProductResponseDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(product.getId());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setImage(product.getImage());
        productResponseDTO.setCategory(product.getCategory().getId());
        return productResponseDTO;
    }
}

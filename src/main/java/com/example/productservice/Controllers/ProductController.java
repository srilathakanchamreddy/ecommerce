package com.example.productservice.Controllers;

import com.example.productservice.DTOs.ProductMapper;
import com.example.productservice.DTOs.ProductRequestDTO;
import com.example.productservice.DTOs.ProductResponseDTO;
import com.example.productservice.Exceptions.CategoryNotFoundException;
import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import com.example.productservice.Services.CategoryService;
import com.example.productservice.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RequestMapping("/product")
@RestController
public class ProductController {
    private ProductService productService;
    private CategoryService categoryService;
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }
    @PostMapping("/create")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productDTO) {
        Category category = categoryService.getCategory(productDTO.getCategory());
        if(category==null)
            throw new CategoryNotFoundException("Category with id "+productDTO.getCategory()+" not found");
        Product product = ProductMapper.toProduct(productDTO);
        product.setCategory(category);
        product = productService.createProduct(product);
        return new ResponseEntity<>(ProductMapper.toProductResponseDTO(product), HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long id) {
        Product product= productService.getProduct(id);
        if(product==null)
            throw new CategoryNotFoundException("Product with id "+id+" not found");
        return new ResponseEntity<>(ProductMapper.toProductResponseDTO(product), HttpStatus.OK);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO productDTO) {
        Category category = categoryService.getCategory(productDTO.getCategory());
        if(category==null)
            throw new CategoryNotFoundException("Category with id "+productDTO.getCategory()+" not found");
        Product product = ProductMapper.toProduct(productDTO);
        product.setCategory(category);
        product = productService.updateProduct(id,product);
        if(product==null)
            throw new CategoryNotFoundException("Product with id "+id+" not found");
        return new ResponseEntity<>(ProductMapper.toProductResponseDTO(product), HttpStatus.OK);
    }



}

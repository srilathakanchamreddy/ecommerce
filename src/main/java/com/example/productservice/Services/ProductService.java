package com.example.productservice.Services;

import com.example.productservice.Models.Product;
import com.example.productservice.Repositaries.ProductRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepo productRepo;
    ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Product getProduct(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product product) {
        Product product1 = productRepo.findById(id).orElse(null);
        if(product1==null)
            return null;
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setImage(product.getImage());
        product1.setCategory(product.getCategory());
        return productRepo.save(product1);
    }
}

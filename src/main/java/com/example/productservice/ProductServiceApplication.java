package com.example.productservice;

import jdk.javadoc.doclet.Doclet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages={"com.example.productservice.Controllers","com.example.productservice.Services","com.example.productservice.Repositaries","com.example.productservice.Models","com.example.productservice.DTOs","com.example.productservice.Exceptions"})
public class ProductServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProductServiceApplication.class, args);
    }


}

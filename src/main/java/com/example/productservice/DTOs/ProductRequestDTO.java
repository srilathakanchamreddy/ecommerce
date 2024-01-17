package com.example.productservice.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductRequestDTO {
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Long category;
    @NotNull
    private String image;
}

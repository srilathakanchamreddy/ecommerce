package com.example.productservice.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequestDTO {

    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String image;

}

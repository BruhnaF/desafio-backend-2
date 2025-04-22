package com.simplesdental.product.service.category;

import com.simplesdental.product.model.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateRequest {
    @NotBlank(message = "name required")
    @Size(max = 100, message = "name must be at most 100 characters")
    private String name;
    @Size(max = 255, message = "description must be at most 255 characters")
    private String description;

    public Category toModel() {
        Category newCategory = new Category();
        newCategory.setName(name);
        newCategory.setDescription(description);
        return newCategory;
    }
}

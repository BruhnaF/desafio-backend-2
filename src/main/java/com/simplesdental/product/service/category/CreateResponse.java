package com.simplesdental.product.service.category;



import com.simplesdental.product.model.Category;

import lombok.Data;

@Data
public class CreateResponse {
    public CreateResponse(Category category) {
        this.id = category.getId();
        this.description = category.getDescription();
        this.name = category.getName();
    }

    private Long id;
    private String name;
    private String description;
}

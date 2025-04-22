package com.simplesdental.product.service.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.simplesdental.product.model.Category;
import com.simplesdental.product.repository.CategoryRepository;
import com.simplesdental.product.service.ObjectsValidator;
import com.simplesdental.product.service.Result;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ObjectsValidator<CreateRequest> postValidator;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Result<CreateResponse> save(CreateRequest category) {
        Result<CreateResponse> response = new Result<>();

        var violations = postValidator.validate(category);

        if (!violations.isEmpty()) {
            response.setErrors(new ArrayList<>(violations));
            return response;
        }

        Category newCategory = categoryRepository.save(category.toModel());
        CreateResponse categoryResponse = new CreateResponse(newCategory);
        response.setData(categoryResponse);

        return response;
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
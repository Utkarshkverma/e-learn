package com.vermau2k01053.category_service.exception;

public class CategoryNotFoundException extends RuntimeException {

    String id;
    public CategoryNotFoundException(String id) {
        super(String.format("Category with id %s not found", id));
    }
}

package com.vermau2k01053.category_service.service;

import com.vermau2k01053.category_service.dto.CategoryDto;
import com.vermau2k01053.category_service.dto.CustomPageResponseDto;

public interface ICategoryService {

    CategoryDto insert(CategoryDto categoryDto);
    CategoryDto get(String categoryId);
    void delete(String categoryId);
    CategoryDto update(CategoryDto categoryDto, String categoryId);

    CustomPageResponseDto<CategoryDto> getAll(int pageNumber, int pageSize, String sortBy);

}

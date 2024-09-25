package com.vermau2k01053.category_service.mapper;

import com.vermau2k01053.category_service.dto.CategoryDto;
import com.vermau2k01053.category_service.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category dtoToEntity(CategoryDto dto) {
        Category category = new Category();
        category.setTitle(dto.getTitle());
        category.setDescription(dto.getDescription());
        return category;
    }

    public CategoryDto entityToDto(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setTitle(category.getTitle());
        dto.setDescription(category.getDescription());
        dto.setAddedDate(category.getAddedDate());
        return dto;
    }
}

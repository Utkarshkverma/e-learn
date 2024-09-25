package com.vermau2k01053.category_service.service.impl;

import com.vermau2k01053.category_service.dto.CategoryDto;
import com.vermau2k01053.category_service.dto.CustomPageResponseDto;
import com.vermau2k01053.category_service.entity.Category;
import com.vermau2k01053.category_service.exception.CategoryNotFoundException;
import com.vermau2k01053.category_service.mapper.CategoryMapper;
import com.vermau2k01053.category_service.repository.CategoryRepository;
import com.vermau2k01053.category_service.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDto insert(CategoryDto categoryDto) {
        var category = categoryMapper.dtoToEntity(categoryDto);
        category.setId(UUID.randomUUID().toString());
        category.setAddedDate(new Date());
        return categoryMapper.entityToDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDto get(String categoryId) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
        return categoryMapper.entityToDto(category);
    }

    @Override
    public void delete(String categoryId) {
        categoryRepository
                .findById(categoryId)
                .ifPresentOrElse(categoryRepository::delete,()->{
                    throw new CategoryNotFoundException(categoryId);
                });
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, String categoryId) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());
        category.setAddedDate(new Date());
        return categoryMapper.entityToDto(categoryRepository.save(category));
    }

    @Override
    public CustomPageResponseDto<CategoryDto> getAll(int pageNumber, int pageSize, String sortBy) {
        Sort sort = Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        Page<Category> categoryPage = categoryRepository.findAll(pageRequest);
        List<Category> all = categoryPage.getContent();
        List<CategoryDto> categoryDtoList = all.stream().map(categoryMapper::entityToDto).toList();
        CustomPageResponseDto<CategoryDto> customPageResponse = new CustomPageResponseDto<>();
        customPageResponse.setContent(categoryDtoList);
        customPageResponse.setLast(categoryPage.isLast());
        customPageResponse.setTotalElements(categoryPage.getTotalElements());
        customPageResponse.setTotalPages(categoryPage.getTotalPages());
        customPageResponse.setPageNumber(pageNumber);
        customPageResponse.setPageSize(categoryPage.getSize());
        return customPageResponse;
    }
}

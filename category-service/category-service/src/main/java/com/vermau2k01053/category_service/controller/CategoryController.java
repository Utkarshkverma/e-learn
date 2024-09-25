package com.vermau2k01053.category_service.controller;

import com.vermau2k01053.category_service.constant.AppConstant;
import com.vermau2k01053.category_service.dto.CategoryDto;
import com.vermau2k01053.category_service.dto.CustomMessageDto;
import com.vermau2k01053.category_service.dto.CustomPageResponseDto;
import com.vermau2k01053.category_service.service.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory
            (@RequestBody @Valid CategoryDto categoryDto) {
        CategoryDto insert = categoryService.insert(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(insert);
    }

    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable String catId) {
        CategoryDto categoryDto = categoryService.get(catId);
        return ResponseEntity.status(HttpStatus.FOUND).body(categoryDto);
    }

    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable String catId, @RequestBody @Valid CategoryDto categoryDto) {
        CategoryDto insert = categoryService.update(categoryDto, catId);
        return ResponseEntity.status(HttpStatus.OK).body(insert);
    }

    @DeleteMapping("/{catId}")
    public ResponseEntity<CustomMessageDto> deleteCategory(@PathVariable String catId) {
        categoryService.delete(catId);
        var customMessage = new CustomMessageDto();
        customMessage.setMessage("Category deleted successfully");
        customMessage.setSuccess(true);
        customMessage.setHttpStatus(HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(customMessage);
    }

    @GetMapping
    public ResponseEntity<CustomPageResponseDto<CategoryDto>> getAll(
            @RequestParam(value = "pageNumber", required = false, defaultValue = AppConstant.DEFAULT_PAGE_NUMBER) int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = AppConstant.DEFAULT_PAGE_SIZE) int pageSize,
            @RequestParam(value = "sortBy", required = false, defaultValue = AppConstant.DEFAULT_SORT_BY) String sortBy
    ) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(categoryService.getAll(pageNumber, pageSize, sortBy));

    }


}

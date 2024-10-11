package com.vermau2k01053.course_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomPageResponseDto<T>
{
    private  int pageNumber;
    private int pageSize;
    private long totalElements;
    private  int totalPages;
    private boolean isLast;
    private List<T> content;
}

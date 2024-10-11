package com.vermau2k01053.course_service.dto;

import lombok.Data;
import org.springframework.core.io.Resource;

@Data
public class ResourceContentTypeDto {

    private Resource resource;
    private  String contentType;
}

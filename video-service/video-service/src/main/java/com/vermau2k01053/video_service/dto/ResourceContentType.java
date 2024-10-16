package com.vermau2k01053.video_service.dto;

import lombok.Data;
import org.springframework.core.io.Resource;

@Data
public class ResourceContentType {

    private Resource resource;
    private  String contentType;
}

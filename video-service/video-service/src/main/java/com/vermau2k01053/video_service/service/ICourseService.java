package com.vermau2k01053.video_service.service;

import com.vermau2k01053.video_service.dto.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "course-service", url = "http://localhost:7071/api")
public interface ICourseService {

    @GetMapping("/courses/{id}")
    CourseDto getCourseById(@PathVariable String id);
}

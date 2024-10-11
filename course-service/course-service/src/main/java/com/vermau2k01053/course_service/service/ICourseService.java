package com.vermau2k01053.course_service.service;

import com.vermau2k01053.course_service.dto.CourseDto;
import com.vermau2k01053.course_service.dto.ResourceContentTypeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ICourseService {
    CourseDto createCourse(CourseDto courseDto);
    CourseDto updateCourse(String id, CourseDto courseDto);
    CourseDto getCourseById(String id);
    Page<CourseDto> getAllCourses(Pageable pageable);
    void deleteCourse(String id);
    List<CourseDto> searchCourses(String keyword);
    CourseDto saveBanner(MultipartFile file, String courseId) throws IOException;
    ResourceContentTypeDto getCourseBannerById(String courseId);
}

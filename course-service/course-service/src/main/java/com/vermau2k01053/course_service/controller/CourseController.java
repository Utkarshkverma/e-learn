package com.vermau2k01053.course_service.controller;

import com.vermau2k01053.course_service.dto.CourseDto;
import com.vermau2k01053.course_service.dto.CustomMessageDto;
import com.vermau2k01053.course_service.service.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final ICourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CourseDto courseDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(courseService.createCourse(courseDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourse(
            @PathVariable String id, @RequestBody CourseDto courseDto) {
        return ResponseEntity.ok(courseService.updateCourse(id, courseDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable String id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @GetMapping
    public ResponseEntity<Page<CourseDto>> getAllCourses(Pageable pageable) {
        return ResponseEntity.ok(courseService.getAllCourses(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<CourseDto>> searchCourses(
            @RequestParam String keyword) {
        return ResponseEntity.ok(courseService.searchCourses(keyword));
    }

    @PostMapping("/{courseId}/banners")
    public ResponseEntity<?> uploadBanner(@PathVariable String courseId, @RequestParam("banner") MultipartFile banner) throws IOException {
        String contentType = banner.getContentType();

        if (contentType == null) {
            contentType = "image/png";
        } else if (contentType.equalsIgnoreCase("image/png") || contentType.equalsIgnoreCase("image/jpeg")) {
        } else {
            CustomMessageDto customMessage = new CustomMessageDto();
            customMessage.setSuccess(false);
            customMessage.setMessage("Invalid file");
            customMessage.setHttpStatus(HttpStatus.BAD_REQUEST);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customMessage);
        }
        CourseDto courseDto = courseService.saveBanner(banner, courseId);
        return ResponseEntity.ok(courseDto);

    }



}

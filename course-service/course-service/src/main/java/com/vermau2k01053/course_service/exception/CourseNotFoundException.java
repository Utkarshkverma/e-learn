package com.vermau2k01053.course_service.exception;

public class CourseNotFoundException extends RuntimeException {

    String id;
    public CourseNotFoundException(String id) {
        super(String.format("Course with id %s not found", id));
    }
}

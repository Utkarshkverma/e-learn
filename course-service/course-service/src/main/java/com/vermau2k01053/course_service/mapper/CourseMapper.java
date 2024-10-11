package com.vermau2k01053.course_service.mapper;

import com.vermau2k01053.course_service.dto.CourseDto;
import com.vermau2k01053.course_service.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course dtoToEntity(CourseDto dto) {
        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setShortDesc(dto.getShortDesc());
        course.setLongDesc(dto.getLongDesc());
        course.setPrice(dto.getPrice());
        course.setLive(dto.isLive());
        course.setDiscount(dto.getDiscount());


        return course;
    }

    public CourseDto entityToDto(Course course) {

        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setTitle(course.getTitle());
        courseDto.setShortDesc(course.getShortDesc());
        courseDto.setLongDesc(course.getLongDesc());
        courseDto.setPrice(course.getPrice());
        courseDto.setLive(course.isLive());
        courseDto.setDiscount(course.getDiscount());
        courseDto.setBanner(course.getBanner());
        courseDto.setCreatedDate(course.getCreatedDate());

        return courseDto;
    }
}

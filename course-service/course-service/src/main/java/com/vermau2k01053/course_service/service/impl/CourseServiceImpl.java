package com.vermau2k01053.course_service.service.impl;

import com.vermau2k01053.course_service.constant.AppConstant;
import com.vermau2k01053.course_service.dto.CourseDto;
import com.vermau2k01053.course_service.dto.ResourceContentTypeDto;
import com.vermau2k01053.course_service.entity.Course;
import com.vermau2k01053.course_service.exception.CourseNotFoundException;
import com.vermau2k01053.course_service.mapper.CourseMapper;
import com.vermau2k01053.course_service.repository.CourseRepository;
import com.vermau2k01053.course_service.service.ICourseService;
import com.vermau2k01053.course_service.service.IFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final IFileService fileService;


    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = courseMapper.dtoToEntity(courseDto);
        course.setId(UUID.randomUUID().toString());
        course.setCreatedDate(new Date());
        return courseMapper.entityToDto(courseRepository.save(course));
    }

    @Override
    public CourseDto updateCourse(String id, CourseDto dto) {
        Course course = courseRepository
                .findById(id)
                .orElseThrow(()-> new CourseNotFoundException(id));

        course.setTitle(dto.getTitle());
        course.setShortDesc(dto.getShortDesc());
        course.setLongDesc(dto.getLongDesc());
        course.setPrice(dto.getPrice());
        course.setLive(dto.isLive());
        course.setDiscount(dto.getDiscount());

        return courseMapper.entityToDto(courseRepository.save(course));
    }

    @Override
    public CourseDto getCourseById(String courseId) {
        Course course = courseRepository
                .findById(courseId)
                .orElseThrow(()-> new CourseNotFoundException(courseId));

        return courseMapper.entityToDto(course);

    }

    @Override
    public Page<CourseDto> getAllCourses(Pageable pageable) {
        Page<Course> courses = courseRepository.findAll(pageable);
        List<CourseDto> dtos = courses.getContent()
                .stream()
                .map(courseMapper::entityToDto)
                .toList();
        return new PageImpl<>(dtos, pageable, courses.getTotalElements());
    }

    @Override
    public void deleteCourse(String id) {
      courseRepository.findById(id).ifPresentOrElse(courseRepository::delete, () -> {
          throw new CourseNotFoundException(id);
      });
    }

    @Override
    public List<CourseDto> searchCourses(String keyword) {
        List<Course> courses = courseRepository
                .findByTitleContainingIgnoreCaseOrShortDescContainingIgnoreCase(keyword, keyword);

        return courses
                .stream()
                .map(courseMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto saveBanner(MultipartFile file, String courseId) throws IOException {
        Course course = courseRepository
                .findById(courseId)
                .orElseThrow(()-> new CourseNotFoundException(courseId));
        String filePath = fileService.save(file, AppConstant.COURSE_BANNER_UPLOAD_DIR, file.getOriginalFilename());
        course.setBanner(filePath);
        course.setBannerContentType(file.getContentType());
        return courseMapper.entityToDto(course);
    }

    @Override
    public ResourceContentTypeDto getCourseBannerById(String courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException("Course not found!!"));
        String bannerPath = course.getBanner();
        Path path = Paths.get(bannerPath);
        Resource resource=new FileSystemResource(path);
        ResourceContentTypeDto resourceContentType = new ResourceContentTypeDto();
        resourceContentType.setResource(resource);
        resourceContentType.setContentType(course.getBannerContentType());
        return resourceContentType;

    }


}

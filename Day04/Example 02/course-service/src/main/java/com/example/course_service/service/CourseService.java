package com.example.course_service.service;

import com.example.course_service.dto.CourseDto;
import com.example.course_service.entity.Course;
import com.example.course_service.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public Course addCourse(CourseDto courseDto) {
        Course course = Course.builder()
                .name(courseDto.getName())
                .category(courseDto.getCategory())
                .duration(courseDto.getDuration())
                .build();
        return courseRepository.save(course);
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("there is no records in given id"));
    }
}

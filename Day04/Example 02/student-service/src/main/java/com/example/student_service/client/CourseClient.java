package com.example.student_service.client;

import com.example.student_service.dto.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "course-service",url = "http://localhost:8081")
public interface CourseClient {
    @GetMapping("/course")
    public List<CourseDto> getAllCourse();

    @PostMapping("/course")
    public CourseDto addCourse(@RequestBody CourseDto courseDto);

    @GetMapping("course/id/{id}")
    public CourseDto getCourseById(@PathVariable Long id);
    @GetMapping("course/name/{name}")
    public CourseDto getCourseByName(@PathVariable String name);
}

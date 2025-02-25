package com.example.course_service.controller;

import com.example.course_service.dto.CourseDto;
import com.example.course_service.entity.Course;
import com.example.course_service.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/course")
@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @GetMapping()
    public List<Course> getAllCourse(){
        return service.getAllCourse();
    }

    @PostMapping()
    public Course addCourse(@RequestBody CourseDto courseDto){
        return service.addCourse(courseDto);
    }

    @GetMapping("/id/{id}")
    public Course getCourseById(@PathVariable Long id){
        return service.getCourseById(id);
    }

    @GetMapping("/name/{name}")
    public Course getCourseByName(@PathVariable String name){
        return service.getCourseByName(name);
    }
}

package com.example.student_service.client;

import com.example.student_service.dto.FacultyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "faculty-client",url = "http://localhost:8083")
public interface FacultyClient {
    @GetMapping("/faculty")
    public List<FacultyDto> getAllFaculties();

    @GetMapping("faculty/id/{id}")
    public FacultyDto getFacultyById(@PathVariable Long id);

    @PostMapping("/faculty")
    public FacultyDto addFacultyDetails(@RequestBody FacultyDto facultyDto);

    @GetMapping("faculty/name/{name}")
    public FacultyDto getFacultyByName(@PathVariable String name);
}

package com.example.faculty_service.controller;

import com.example.faculty_service.dto.FacultyDto;
import com.example.faculty_service.entity.Faculty;
import com.example.faculty_service.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping()
    public List<Faculty> getAllFaculties(){
        return facultyService.getAllFaculties();
    }

    @GetMapping("/id/{id}")
    public Faculty getFacultyById(@PathVariable Long id){
        return facultyService.getFacultyById(id);
    }

    @GetMapping("/name/{name}")
    public Faculty getFacultyByName(@PathVariable String name){
        return facultyService.getFacultyByName(name);
    }

    @PostMapping()
    public Faculty addFacultyDetails(@RequestBody FacultyDto facultyDto){
        return facultyService.addFacultyDetails(facultyDto);
    }
}

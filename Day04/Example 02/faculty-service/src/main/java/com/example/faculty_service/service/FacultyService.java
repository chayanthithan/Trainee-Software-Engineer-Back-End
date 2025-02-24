package com.example.faculty_service.service;

import com.example.faculty_service.dto.FacultyDto;
import com.example.faculty_service.entity.Faculty;
import com.example.faculty_service.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyService {

    private final FacultyRepository repository;

    public List<Faculty> getAllFaculties() {
        return repository.findAll();
    }

    public Faculty getFacultyById(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("no records in the given id"));
    }

    public Faculty addFacultyDetails(FacultyDto facultyDto) {
        Faculty faculty = Faculty.builder()
                .name(facultyDto.getName())
                .numOfLecturers(facultyDto.getNumOfLecturers())
                .numOfStudents(facultyDto.getNumOfStudents())
                .numOfDepartments(facultyDto.getNumOfDepartments())
                .build();
        return repository.save(faculty);
    }

}

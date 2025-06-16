package com.example.management_department_service.service;

import com.example.management_department_service.api.dto.StudentDto;
import com.example.management_department_service.api.dto.StudentResponseDto;
import com.example.management_department_service.api.dto.StudentResponseDtoNew;
import com.example.management_department_service.constants.ApplicationConstants;
import com.example.management_department_service.converter.StudentConverter;
import com.example.management_department_service.entity.Students;
import com.example.management_department_service.exception.ServiceException;
import com.example.management_department_service.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;
    public StudentResponseDto saveStudentDetails(StudentDto studentDto) {
        Students students = studentRepository.save(studentConverter.convert(studentDto));
        return StudentResponseDto.builder()
                .status("Successfully saved")
                .id(students.getRegNum())
                .build();
    }

    public List<StudentResponseDtoNew> getStudents() {
        return studentRepository.getAllStudentDetails();
    }

    public int getStudentCount() {
        return studentRepository.findAllStudentCount();
    }

    public String deleteManagementStudent(String regNum) {
        Optional<Students> response = studentRepository.findById(regNum);
        if(response.isPresent()){
            studentRepository.deleteById(regNum);
            return "successfully deleted";
        }else{
            throw new ServiceException(ApplicationConstants.BAD_REQUEST,HttpStatus.BAD_REQUEST,"BAD REQUEST");
        }
    }

    public Students updateExistingStudent(Students students) {
        Optional<Students> existingStudentOptional = studentRepository.findById(students.getRegNum());
        if (existingStudentOptional.isPresent()) {
            Students existingStudent = existingStudentOptional.get();

            existingStudent.setAccYear(students.getAccYear());
            existingStudent.setAge(students.getAge());
            existingStudent.setDob(students.getDob());
            existingStudent.setCourse(students.getCourse());
            existingStudent.setAddress(students.getAddress());
            existingStudent.setGender(students.getGender());
            existingStudent.setFullName(students.getFullName());

            return studentRepository.save(existingStudent);
        } else {
            // Handle the case where the student is not found
            throw new ServiceException(ApplicationConstants.SERVICE_ID_NOT_FOUND,HttpStatus.NOT_FOUND,"Not found");
        }
    }
}

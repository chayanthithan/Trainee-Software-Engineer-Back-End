package com.example.management_department_service.converter;

import com.example.management_department_service.api.dto.StudentDto;
import com.example.management_department_service.entity.Students;
import com.example.management_department_service.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudentConverter {
    private final StudentRepository studentRepository;
    public Students convert(StudentDto studentDto){
//        can't apply split method for enum so first convert it to string using name()
        String name[] = studentDto.getCourse().name().split("_");
        String tempName = Arrays.stream(name).map(word->
                String.valueOf(word.charAt(0)))
                .collect(Collectors.joining());

        Pageable pageable = (Pageable) PageRequest.of(0, 1);  // Fetch only 1 result
        List<String> results = studentRepository.findByCourseCode(tempName, pageable);

        Optional<String> latestRegNum = results.stream().findFirst(); // Convert list to Optional

        String newCode = "";
        if(!latestRegNum.isPresent()){
            newCode = studentDto.getAccYear() +"/"+tempName+"/"+"01";
        }else {
            List<String> arr = Arrays.stream(latestRegNum.get().split("/")).toList();
            String num = arr.get(arr.size() - 1);
            int getNum = Integer.parseInt(num);
//            String formattedNum = String.format("%02d", getNum + 1);
            newCode = studentDto.getAccYear() + "/" + tempName + "/" + (getNum + 1);
        }

        return Students.builder()
                .regNum(newCode)
                .age(studentDto.getAge())
                .accYear(studentDto.getAccYear())
                .dob(studentDto.getDob())
                .Address(studentDto.getAddress())
                .course(studentDto.getCourse())
                .fullName(studentDto.getFullName())
                .gender(studentDto.getGender())
                .build();
            }
}

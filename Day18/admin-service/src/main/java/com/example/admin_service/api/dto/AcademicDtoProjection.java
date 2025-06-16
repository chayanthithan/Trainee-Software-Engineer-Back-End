package com.example.admin_service.api.dto;

import com.example.admin_service.enums.Faculty;
import com.example.admin_service.enums.Job;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AcademicDtoProjection {
    private String id;
    private String fullName;
    private Job job;
    private Faculty faculty;
}

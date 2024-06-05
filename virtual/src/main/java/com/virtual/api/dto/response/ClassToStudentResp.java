package com.virtual.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.virtual.domain.entities.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassToStudentResp {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private Boolean active;
    private List<Student> students;
}

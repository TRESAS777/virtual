package com.virtual.api.dto.response;

import com.virtual.domain.entities.ClassEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentToClassRes {
    private ClassEntity class1;

}

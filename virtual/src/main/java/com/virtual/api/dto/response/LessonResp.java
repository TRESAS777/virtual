package com.virtual.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.virtual.domain.entities.ClassEntity;
import com.virtual.domain.entities.Multimedia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonResp {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Boolean active;
    private ClassEntity class1;
    private List<Multimedia> multimedias;
}

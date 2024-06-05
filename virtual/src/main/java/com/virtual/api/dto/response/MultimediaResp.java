package com.virtual.api.dto.response;

import java.time.LocalDateTime;

import com.virtual.domain.entities.Lesson;
import com.virtual.utils.enums.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultimediaResp {
    private Long id;
    private Type type;
    private String url;
    private LocalDateTime createdAt;
    private Boolean active;
    private Lesson lesson;
}

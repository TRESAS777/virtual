package com.virtual.api.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonReq {
    @NotBlank(message = "El titulo es requerido")
    private String title;
    @NotBlank(message = "El contenido es requerido")
    private String content;
    @NotNull(message = "El estado es requerido")
    private Short active;
}

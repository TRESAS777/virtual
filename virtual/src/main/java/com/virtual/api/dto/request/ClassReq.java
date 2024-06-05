package com.virtual.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassReq {
    @NotBlank(message = "El nombre del servicio es requerido.")
    private String name;
    @NotBlank(message = "La descripción es requerida.")
    private String description;
}

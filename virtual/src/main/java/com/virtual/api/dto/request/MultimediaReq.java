package com.virtual.api.dto.request;


import com.virtual.utils.enums.Type;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultimediaReq {
    @NotNull(message = "El typo es requerido")
    private Type type;
    @NotBlank(message = "La url es requerida")
    private String url;
    @NotNull(message = "El estado es requerido")
    private Short active;
}

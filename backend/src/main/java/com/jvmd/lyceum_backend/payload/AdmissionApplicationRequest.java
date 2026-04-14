package com.jvmd.lyceum_backend.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdmissionApplicationRequest {

    @NotBlank
    private String parentName;

    @NotBlank
    private String childName;

    @NotNull
    private Integer childAge;

    @NotBlank
    private String phone;

    private String email;

    /** "1_CLASS" или "PRESCHOOL" */
    @NotBlank
    private String classType;

    private String message;
}

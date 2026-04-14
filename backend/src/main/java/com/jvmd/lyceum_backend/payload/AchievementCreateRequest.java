package com.jvmd.lyceum_backend.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AchievementCreateRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String category;

    @NotBlank
    private String studentName;

    @NotNull
    private Integer year;

    @NotBlank
    private String place;

    @NotBlank
    private String level;
}

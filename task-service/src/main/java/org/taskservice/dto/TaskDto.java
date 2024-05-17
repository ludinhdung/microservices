package org.taskservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskDto(
        @Size(max = 255) @NotBlank String title,
        String description,
        boolean completed,
        Integer assignee
) {
}
package org.taskservice.dto;

public record TaskDetailDto(Integer id, String title, String description,
                            boolean completed, Integer assigneeId,
                            String assigneeName, String assigneeEmail) {
}
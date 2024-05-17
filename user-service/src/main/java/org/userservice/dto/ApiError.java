package org.userservice.dto;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

public record ApiError(
        HttpStatus status,
        String message,
        List<String> errors
) implements Serializable {
}

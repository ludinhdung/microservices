package org.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.userservice.dto.ApiError;
import org.userservice.exception.UserAlreadyExistsException;
import org.userservice.exception.UserNotFountException;

import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleUserNotFoundException(UserNotFountException ex) {
        return new ApiError(HttpStatus.NOT_FOUND, "Not found error", Collections.singletonList(ex.getMessage()));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return new ApiError(HttpStatus.CONFLICT, "Already exists error", Collections.singletonList(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<String> listErrors = fieldErrors.stream().map(FieldError::getDefaultMessage).toList();

        return new ApiError(HttpStatus.BAD_REQUEST, "Validation error", listErrors);
    }

}

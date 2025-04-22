package com.example.spring_boot.adapter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.spring_boot.domain.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFound(UserNotFoundException ex) {
        return new ErrorResponse("NOT_FOUND", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGeneric(Exception ex) {
        return new ErrorResponse("INTERNAL_ERROR", "Unexpected error occurred");
    }

    static class ErrorResponse {
        public String code, message;

        public ErrorResponse(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }

}

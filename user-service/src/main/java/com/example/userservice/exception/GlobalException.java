package com.example.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserEmailAlreadyAvailableException.class)
    public String handler(UserEmailAlreadyAvailableException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<?> handle(DepartmentNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DepartmentServiceUnavailableException.class)
    public ResponseEntity<?> handel(DepartmentServiceUnavailableException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handel(UserNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}

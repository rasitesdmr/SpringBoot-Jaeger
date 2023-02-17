package com.example.userservice.exception;

public class UserEmailAlreadyAvailableException extends RuntimeException{

    public UserEmailAlreadyAvailableException() {
    }

    public UserEmailAlreadyAvailableException(String message) {
        super(message);
    }

    public UserEmailAlreadyAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserEmailAlreadyAvailableException(Throwable cause) {
        super(cause);
    }
}

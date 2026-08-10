package com.example.demo.rest;

public class StudentNotFound extends RuntimeException {
    public StudentNotFound(Throwable cause) {
        super(cause);
    }

    public StudentNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFound(String message) {
        super(message);
    }
}

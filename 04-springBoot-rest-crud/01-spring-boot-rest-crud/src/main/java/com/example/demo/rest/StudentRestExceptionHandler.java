package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFound(Exception exec){

        StudentErrorResponse response = new StudentErrorResponse();

        response.setMessage(exec.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimeStamp(System.currentTimeMillis());

        return  new ResponseEntity<StudentErrorResponse>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleGeneralException(StudentNotFound exec){

        StudentErrorResponse response = new StudentErrorResponse();

        response.setMessage(exec.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTimeStamp(System.currentTimeMillis());

        return  new ResponseEntity<StudentErrorResponse>(response, HttpStatus.BAD_REQUEST);
    }
}

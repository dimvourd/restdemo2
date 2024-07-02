package com.luv2code.demo.exception_handlers;

import com.luv2code.demo.errors.StudentErrorResponse;
import com.luv2code.demo.exceptions.StudentNotFoundException;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


// Global Student Exception Handler
@ControllerAdvice
@Lazy
public class StudentRestExceptionHandler {
    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> studentExceptionHandler(StudentNotFoundException ex){


        // create a StudentErrorResponse
        StudentErrorResponse response = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());

        // return ResponseEntity
        ResponseEntity<StudentErrorResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> studentExceptionHandler(Exception ex){


        // create a StudentErrorResponse
        StudentErrorResponse response = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());

        // return ResponseEntity
        ResponseEntity<StudentErrorResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

}

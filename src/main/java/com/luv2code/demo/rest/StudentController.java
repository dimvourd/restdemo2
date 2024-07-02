package com.luv2code.demo.rest;


import com.luv2code.demo.errors.StudentErrorResponse;
import com.luv2code.demo.exceptions.StudentNotFoundException;
import com.luv2code.demo.pojo.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class StudentController {
    private List<Student> theStudents;

    @PostConstruct
    private void initStudents(){
        theStudents = new ArrayList<>(3);
        theStudents.add(new Student("dim", "vrd"));
        theStudents.add(new Student("john", "vrd"));
        theStudents.add(new Student("sophia", "vrd"));
    }


    @GetMapping("/students")
    public List<Student> getAllStudents(){

        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable("studentId") Integer Id){

        if(Id < 0 || Id >= theStudents.size())
            throw new StudentNotFoundException("Id does not exists.");
        return theStudents.get(Id);
    }

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

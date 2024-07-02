package com.luv2code.demo.rest;


import com.luv2code.demo.pojo.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return theStudents.get(Id);
    }



}

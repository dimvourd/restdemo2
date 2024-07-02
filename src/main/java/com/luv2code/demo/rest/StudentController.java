package com.luv2code.demo.rest;


import com.luv2code.demo.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class StudentController {

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> sts = new ArrayList<>(3);
        sts.add(new Student("dim", "vrd"));
        sts.add(new Student("john", "vrd"));
        sts.add(new Student("sophia", "vrd"));

        return sts;
    }


}

package com.example.demo.Controller;

import java.util.Collection;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * StudentController
 */

 @RestController
 @RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;



    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }
}
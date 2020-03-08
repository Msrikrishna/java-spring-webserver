package com.example.demo.controller;

import java.util.*;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
/**
 * StudentController
 */

 @RestController
 @RequestMapping("/students")
public class StudentController {
	final static Logger logger = LoggerFactory.getLogger(StudentController.class);


    @Autowired
    private StudentService studentService;


    @RequestMapping(method = RequestMethod.GET, value="")
    public List<Student> getAllStudents()
    {   
        logger.info("Fetched all students");     
        return studentService.getAllStudents();
         
    }

    @RequestMapping(method = RequestMethod.POST, value="deleteall")
    public String deleteAllStudents()
    {   
        studentService.deleteAllStudents();
         return "Deleted all students in the DB";
    }


    //This also outputs a html page
    @RequestMapping(method = RequestMethod.GET, value = "greeting")
    public String greeting(@RequestParam(name ="name", required = false, defaultValue = "World") String name, Model model)
    {
        
        model.addAttribute("name", name);

        return "greeting";
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.GET )
    public Student getStudentById(@PathVariable("id")  Long id) 
    {

        Student student = new Student();
        try {
           
             student = studentService.getStudentById(id).get();
        } catch (NoSuchElementException e) {
            
        }
        
        return student;
    }


    //Any POST request will be handled by this
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, method =RequestMethod.POST, value="create")
    public String insertStudent(@RequestBody Student student){
        
        studentService.save(student);
        return "Created Student!"+ student.toString();

    }



    


}
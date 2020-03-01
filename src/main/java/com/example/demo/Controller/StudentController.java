package com.example.demo.controller;

import java.util.Collection;

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
import org.apache.logging.log4j.*;

/**
 * StudentController
 */

 @RestController
 @RequestMapping("/students")
public class StudentController {
    final static Logger logger = LogManager.getLogger(StudentController.class);


    @Autowired
    private StudentService studentService;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents()
    {   
        logger.info("Fetched all students");     
        return studentService.getAllStudents();
         
    }

    @RequestMapping(method = RequestMethod.GET, value = "greeting")
    public String greeting(@RequestParam(name ="name", required = false, defaultValue = "World") String name, Model model)
    {
        
        model.addAttribute("name", name);

        return "greeting";
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id")  int id)
    {
        return studentService.getStudentById(id);
    }

    @RequestMapping(consumes = MediaType.TEXT_PLAIN_VALUE, method =RequestMethod.POST)
    public String echoString(@RequestBody String string){
        
        return string;

    }

    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, method =RequestMethod.PUT)
    public void insertStudent(@RequestBody Student student){
        
       studentService.insertStudent(student);

    }






}
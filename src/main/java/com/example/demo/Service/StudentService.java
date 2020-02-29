package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import org.apache.logging.log4j.*;

/**
 * StudentService
 */

 @Service
public class StudentService {
    final static Logger logger = LogManager.getLogger(StudentService.class);

    @Autowired
    private StudentDao studentDao;


    public Collection<Student> getAllStudents()
    {
        return studentDao.getAllStudents();
    }

    public Student getStudentById(int id)
    {
        return studentDao.getStudentById(id);
    }

    public void insertStudent(Student student){

        studentDao.insertStudent(student);
   }

}
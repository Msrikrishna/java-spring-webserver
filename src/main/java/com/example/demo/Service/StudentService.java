package com.example.demo.Service;

import com.example.demo.Dao.*;
import com.example.demo.Entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * StudentService
 */

 @Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;


    public Collection<Student> getAllStudents()
    {
        return studentDao.getAllStudents();
    }



}
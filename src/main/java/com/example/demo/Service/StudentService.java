package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.MDC;
/**
 * StudentService
 */

 @Service
public class StudentService {
	final static Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentDao studentDao;


    public Collection<Student> getAllStudents()
    {
        return studentDao.getAllStudents();
    }

    public Student getStudentById(int id)
    {
        MDC.put("ClientId",Integer.toString(id)); 
        
        /**Even if multiple clients do this at the same time, the log will 
        maintain integrity of the flow for every user by mapping them with this command.
        This key's should then be used in the log-properties-layout like so {ClientId}
        

        Note: Logs are always arranged in increasing order of time. This allows us to track a particular users
        ops
        **/

        // Do something here with this particular clientid\

        MDC.clear();
        return studentDao.getStudentById(id);
        
    }

    public void insertStudent(Student student){

        studentDao.insertStudent(student);
   }

}



















package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    private StudentRepository studentRepository;

    private List<Student> my_initial_list = new ArrayList<Student>(Arrays.asList(
            new Student(1L, "Sri", "Maths"),
            new Student(2L, "Mansi", "CSE"),
            new Student(3L, "Uwe", "Architecture")

    ));

    public void populateInitialStudents()
    {   
        studentRepository.saveAll(my_initial_list);
       ;
    }

    public Optional<Student> getStudentById(Long id)
    {

        MDC.put("ClientId",Long.toString(id)); 
        
        /**Even if multiple clients do this at the same time, the log will 
        maintain integrity of the flow for every user by mapping them with this command.
        This key's should then be used in the log-properties-layout like so {ClientId}
        

        Note: Logs are always arranged in increasing order of time. This allows us to track a particular users
        ops
        **/

        // Do something here with this particular clientid\

        MDC.clear();
        Optional<Student> findById = studentRepository.findById(id);
        return findById;
        
    }
    public void save(Student student){
        studentRepository.save(student);

    }

    public void create(Student student) {
        studentRepository.save(student);    
    }

    public void delete(Student student) {
        studentRepository.delete(student);    
    }

	public List<Student> getAllStudents() {
          
        List<Student> my_list = new ArrayList<Student>();
        Iterator<Student> my_iterator = studentRepository.findAll().iterator();
        while(my_iterator.hasNext())
        {
            my_list.add(my_iterator.next());
        }

        return my_list;

	}

    



}



















package com.example.demo.entity;


import org.apache.logging.log4j.*;

/**
 * Student
 */

 
public class Student {
    final static Logger logger = LogManager.getLogger(Student.class);

    private int id;
    private String name;
    private String classesEnrolled;

    public Student(int id, String name, String classesEnrolled) {
        this.id = id;
        this.name = name;
        this.classesEnrolled = classesEnrolled;
        logger.info("Student object created with id %d", id);
    }
    public Student() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassesEnrolled() {
        return classesEnrolled;
    }

    public void setClassesEnrolled(String classesEnrolled) {
        this.classesEnrolled = classesEnrolled;
    }
    

}
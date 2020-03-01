package com.example.demo.entity;



import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.slf4j.Logger;

/**
 * Student
 */

@Entity
public class Student {
    final static Logger logger = LoggerFactory.getLogger(Student.class);
    

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) //This automatically generates an Id
    private int id;

    //These are not JPA annotated
    private String name;
    private String classesEnrolled;

    public Student(int id, String name, String classesEnrolled) {
        this.id = id;
        this.name = name;
        this.classesEnrolled = classesEnrolled;
        logger.info("Student object created with id %d", id);
    }
    public Student() {}

    @Override
    public String toString(){

        return String.format("Student[id=%d, name='%s', classesEnrolled='%s']", id,name,classesEnrolled);
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
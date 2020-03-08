package com.example.demo.entity;

import org.slf4j.LoggerFactory;
import org.springframework.data.relational.core.mapping.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;

/**
 * Student
 */

@Entity
@Table
public class Student {
    final static Logger logger = LoggerFactory.getLogger(Student.class);
    

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) //This automatically generates an Id
    private Long id;

    @Column(keyColumn = "Student's name")
    private String name;

    @Column(keyColumn = "Classes he enrolled")
    private String classesEnrolled;

    public Student(Long id, String name, String classesEnrolled) {
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
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
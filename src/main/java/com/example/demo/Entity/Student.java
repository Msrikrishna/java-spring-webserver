package com.example.demo.Entity;


/**
 * Student
 */

 
public class Student {

    private int id;
    private String name;
    private String classesEnrolled;

    public Student(int id, String name, String classesEnrolled) {
        this.id = id;
        this.name = name;
        this.classesEnrolled = classesEnrolled;
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
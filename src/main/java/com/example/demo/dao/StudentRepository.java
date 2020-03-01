package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Student;

import org.springframework.data.repository.CrudRepository;

/**
 * StudentRepository
 */
/**
 * StudentRepository
 */

 //Describes how this repository can be used ie methods avialable


 //The long here denotes the id of the object
 //Here JPARepository can also be used
public interface StudentRepository extends CrudRepository<Student, Long> {

    //More operations on the DB can be definbed here 
     
}
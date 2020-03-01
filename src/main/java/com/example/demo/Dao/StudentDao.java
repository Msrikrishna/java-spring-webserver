package com.example.demo.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.entity.Student;

import org.springframework.stereotype.Repository;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * StudentDao
 */

 @Repository
public class StudentDao {
   private static Map<Integer,Student> students;
   final static Logger logger = LoggerFactory.getLogger(StudentDao.class);

   static 
   {
       students = new HashMap<Integer,Student>();
       students.put(1, new Student(1, "Sri", "Math"));
       students.put(2, new Student(2, "Felipe", "Economics"));
       students.put(3, new Student(3, "Vineeth", "Physics"));
       students.put(4, new Student(4, "Raja", "CSE"));
       logger.info("Created static database");
   }

   public Collection<Student> getAllStudents()
   {
       return students.values();
   }

   public Student getStudentById(int id)
   {
     return students.get(id);

   }

   public void insertStudent(Student student){

        students.put(student.getId(), student);
   }


}
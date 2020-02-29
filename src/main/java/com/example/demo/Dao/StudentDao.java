package com.example.demo.Dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.Entity.Student;

import org.springframework.stereotype.Repository;

/**
 * StudentDao
 */

 @Repository
public class StudentDao {

   private static Map<Integer,Student> students;

   static 
   {
       students = new HashMap<Integer,Student>();
       students.put(1, new Student(1, "Sri", "Math"));
       students.put(2, new Student(2, "Sri", "Math"));
       students.put(3, new Student(3, "Sri", "Math"));
       students.put(4, new Student(4, "Sri", "Math"));
   }

   public Collection<Student> getAllStudents()
   {
       return students.values();
   }


}
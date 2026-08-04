package com.example.demo.dao;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentDao {

   public void save(Student student);

   public Student findById(Integer id);

   List<Student> findAll();

   List<Student> findByLasName(String lasName);

   void update(Student student);

   void delete(Integer id);

   int deleteAll();
}

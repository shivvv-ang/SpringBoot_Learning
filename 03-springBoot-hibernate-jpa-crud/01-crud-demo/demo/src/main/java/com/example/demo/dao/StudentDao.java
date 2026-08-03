package com.example.demo.dao;

import com.example.demo.entity.Student;

public interface StudentDao {

   public void save(Student student);

   public Student findById(Integer id);
}

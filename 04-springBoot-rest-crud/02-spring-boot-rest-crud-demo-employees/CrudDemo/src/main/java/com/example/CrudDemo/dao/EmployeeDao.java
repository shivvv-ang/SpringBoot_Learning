package com.example.CrudDemo.dao;

import com.example.CrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();
}

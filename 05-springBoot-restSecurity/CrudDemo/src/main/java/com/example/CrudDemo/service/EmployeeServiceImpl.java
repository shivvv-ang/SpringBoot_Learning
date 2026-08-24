package com.example.CrudDemo.service;

import com.example.CrudDemo.dao.EmployeeRepository;
import com.example.CrudDemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository TheEmployeeRepository) {
        employeeRepository = TheEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        }else{
            throw new RuntimeException("Employee not found");
        }

        return employee;
    }


    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}

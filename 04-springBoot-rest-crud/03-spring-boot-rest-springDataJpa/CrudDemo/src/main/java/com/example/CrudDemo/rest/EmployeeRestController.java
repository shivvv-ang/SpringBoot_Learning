package com.example.CrudDemo.rest;
import com.example.CrudDemo.entity.Employee;
import com.example.CrudDemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;
    private JsonMapper jsonMapper;

    public EmployeeRestController(EmployeeService theEmployService ,  JsonMapper theJsonMapper) {

        employeeService = theEmployService;
        jsonMapper = theJsonMapper;

    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee( @RequestBody Employee employee) {

        employee.setId(0);

        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PatchMapping("/employees/{employeeId}")
    public  Employee PatchEmployee(@PathVariable int employeeId, @RequestBody Map<String,Object> patchEmp) {

        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }

        if(patchEmp.containsKey("id")){
            throw new  RuntimeException("Employee  id not allowed in request body " + employeeId );
        }

        Employee patchEmployee = jsonMapper.updateValue(employee,patchEmp);

        return employeeService.save(patchEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }

        employeeService.deleteById(employeeId);

        return "Employee with id " + employeeId + " deleted";
    }
}

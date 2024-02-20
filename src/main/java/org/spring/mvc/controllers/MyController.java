package org.spring.mvc.controllers;


import org.spring.mvc.entity.Employee;
import org.spring.mvc.exeption_handlers.EmployeeIncorrectData;
import org.spring.mvc.exeption_handlers.NoSuchEmployeeException;
import org.spring.mvc.services.EmployeeService;
import org.spring.mvc.services.EmployeeServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class MyController {
    private final EmployeeServiceInt employeeService;

    @Autowired
    public MyController(EmployeeServiceInt employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getOneEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("Employee with id: " + id + " doesn't exist");
        }

        return employee;
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        employeeService.saveEmp(employee);
    }

    @PutMapping
    public void update(@RequestBody Employee employee) {

        employeeService.saveEmp(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        Employee employee = getOneEmployee(id);
        if(employee == null){
            throw new NoSuchEmployeeException("Employee with id " + id + " doesn't exist");
        }
        employeeService.deleteEmp(employee);
        return "Employee with id " + id + " was delete successfully";
    }

}

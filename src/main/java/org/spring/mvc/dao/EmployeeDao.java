package org.spring.mvc.dao;

import org.spring.mvc.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> getAllEmployees();
    public void saveEmp(Employee employee);
    public Employee findById(int id);
    public void deleteEmp(Employee employee);
}

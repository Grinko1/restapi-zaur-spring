package org.spring.mvc.services;

import org.spring.mvc.dao.EmployeeDao;
import org.spring.mvc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInt {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();

    }

    @Override
    @Transactional
    public void saveEmp(Employee employee) {
        employeeDao.saveEmp(employee);
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    @Transactional
    public void deleteEmp(Employee employee) {
         employeeDao.deleteEmp(employee);
    }
}

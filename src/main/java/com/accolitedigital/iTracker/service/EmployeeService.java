package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);
    void saveAllEmployee(List<Employee> employees);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    void deleteEmployee(Integer id);
    Employee getEmployeeByEmail(String name);
}

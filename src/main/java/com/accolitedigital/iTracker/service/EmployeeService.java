package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> saveAllEmployee(List<Employee> employees);
    List<Employee> getAllEmployees();
    Employee getEmployee(Integer id);
    Employee updateEmployee(Integer id, Employee employee);
    void deleteEmployee(Integer id);
    Employee getEmployeeByName(String name);
}

package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee getEmployee(Integer id);
    public Employee updateEmployee(Integer id, Employee employee);
    public void deleteEmployee(Integer id);
    public List<Employee> getEmployeesOnPrimarySkill(String primarySkill);
}

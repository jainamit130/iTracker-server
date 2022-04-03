package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> saveAllEmployee(List<Employee> employees);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Integer id, Employee employee);
    void deleteEmployee(Integer id);
    Employee getEmployeeByEmail(String name);
}

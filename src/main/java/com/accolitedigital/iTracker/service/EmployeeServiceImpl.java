package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Employee;
import com.accolitedigital.iTracker.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    private PasswordEncoder passwordEncoder;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder=new BCryptPasswordEncoder();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> saveAllEmployee(List<Employee> employees){
        for (Employee employee:employees) {
            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
            employeeRepository.save(employee);
        }
        return employees;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Integer id,Employee updatedEmployee){
        updatedEmployee.setPassword(passwordEncoder.encode(updatedEmployee.getPassword()));
        return employeeRepository.save(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id); }

    @Override
    public Employee getEmployeeByEmail(String name){
        return employeeRepository.findByEmail(name);
    }
}



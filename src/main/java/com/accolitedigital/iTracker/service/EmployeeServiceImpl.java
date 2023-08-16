package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.exception.UserNotFoundException;
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
    public void saveEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
    }

    @Override
    public void saveAllEmployee(List<Employee> employees){
        for (Employee employee:employees) {
            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
            employeeRepository.save(employee);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void updateEmployee(Employee updatedEmployee){
        updatedEmployee.setPassword(passwordEncoder.encode(updatedEmployee.getPassword()));
        employeeRepository.save(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id); }

    @Override
    public Employee getEmployeeByEmail(String email) throws UserNotFoundException {
        Employee employee= employeeRepository.findByEmail(email);
        if (employee != null)
            return employee;
        else
            throw new UserNotFoundException("Employee with email: "+email+" is not present in the records!");
    }
}



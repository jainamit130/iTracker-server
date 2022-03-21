package com.accolitedigital.iTracker.service;
import com.accolitedigital.iTracker.model.Employee;
import com.accolitedigital.iTracker.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        System.out.println(employeeRepository.findById(employee.getId()));
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Integer id){ return employeeRepository.findById(id).get();}

    @Override
    public Employee updateEmployee(Integer id,Employee updatedEmployee){
        return employeeRepository.save(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id); }

    @Override
    public List<Employee> getEmployeesOnPrimarySkill(String primarySkill) {
        return employeeRepository.findByPrimarySkill(primarySkill);
    }

}



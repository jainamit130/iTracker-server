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
        employee.setEmployeePassword(passwordEncoder.encode(employee.getEmployeePassword()));
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> saveAllEmployee(List<Employee> employees){
        for (Employee employee:employees) {
            employee.setEmployeePassword(passwordEncoder.encode(employee.getEmployeePassword()));
            employeeRepository.save(employee);
        }
        return employees;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Integer id){ return employeeRepository.findById(id).get();}

    @Override
    public Employee updateEmployee(Integer id,Employee updatedEmployee){
        updatedEmployee.setEmployeePassword(passwordEncoder.encode(updatedEmployee.getEmployeePassword()));
        return employeeRepository.save(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id); }

    @Override
    public List<Employee> getEmployeesOnPrimarySkill(String primarySkill) {
        return employeeRepository.findByPrimarySkill(primarySkill);
    }

    @Override
    public List<Employee> getEmployeesOnSecondarySkill(String skill) {
        return employeeRepository.findBySecondarySkill(skill);
    }

    @Override
    public List<Employee> getEmployeesOnTertiarySkill(String skill) {
        return employeeRepository.findByTertiarySkill(skill);
    }

    @Override
    public List<Employee> getEmployeesOnPrimarySkillRound(Integer round) {
        return employeeRepository.findByPrimaryRound(round);
    }

    @Override
    public List<Employee> getEmployeesOnSecondarySkillRound(Integer round) {
        return employeeRepository.findBySecondaryRound(round);
    }

    @Override
    public List<Employee> getEmployeesOnTertiarySkillRound(Integer round) {
        return employeeRepository.findByTertiaryRound(round);
    }

    @Override
    public List<Employee> getEmployeesOnPrimarySkillAndRound(String skill, Integer round) {
        return employeeRepository.findByPrimarySkillAndPrimaryRound(skill,round);
    }

    @Override
    public List<Employee> getEmployeesOnSecondarySkillAndRound(String skill, Integer round) {
        return employeeRepository.findBySecondarySkillAndSecondaryRound(skill,round);
    }

    @Override
    public List<Employee> getEmployeesOnTertiarySkillAndRound(String skill, Integer round) {
        return employeeRepository.findByTertiarySkillAndTertiaryRound(skill,round);
    }

}



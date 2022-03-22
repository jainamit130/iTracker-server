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
    public List<Employee> getEmployeesOnSecondarySkill(String skill);
    public List<Employee> getEmployeesOnTertiarySkill(String skill);
    public List<Employee> getEmployeesOnPrimarySkillRound(Integer round);
    public List<Employee> getEmployeesOnSecondarySkillRound(Integer round);
    public List<Employee> getEmployeesOnTertiarySkillRound(Integer round);
    public List<Employee> getEmployeesOnPrimarySkillAndRound(String skill, Integer round);
    public List<Employee> getEmployeesOnSecondarySkillAndRound(String skill, Integer round);
    public List<Employee> getEmployeesOnTertiarySkillAndRound(String skill, Integer round);
}

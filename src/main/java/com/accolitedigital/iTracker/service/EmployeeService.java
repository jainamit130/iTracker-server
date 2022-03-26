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
    List<Employee> getEmployeesOnPrimarySkill(String primarySkill);
    List<Employee> getEmployeesOnSecondarySkill(String skill);
    List<Employee> getEmployeesOnTertiarySkill(String skill);
    List<Employee> getEmployeesOnPrimarySkillRound(Integer round);
    List<Employee> getEmployeesOnSecondarySkillRound(Integer round);
    List<Employee> getEmployeesOnTertiarySkillRound(Integer round);
    List<Employee> getEmployeesOnPrimarySkillAndRound(String skill, Integer round);
    List<Employee> getEmployeesOnSecondarySkillAndRound(String skill, Integer round);
    List<Employee> getEmployeesOnTertiarySkillAndRound(String skill, Integer round);
}

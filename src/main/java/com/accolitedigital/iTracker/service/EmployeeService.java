package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Employee;

import java.util.List;

public interface EmployeeService {
     Employee saveEmployee(Employee employee);
     List<Employee> getAllEmployees();
     Employee getEmployee(Integer id);
     Employee updateEmployee(Integer id, Employee employee);
     void deleteEmployee(Integer id);
     List<Employee> getEmployeesOnPrimarySkill(String primarySkill);
     List<Employee> getEmployeesOnSecondarySkill(String secondarySkill);
     List<Employee> getEmployeesOnTertiarySkill(String tertiarySkill);
     List<Employee> getEmployeesOnPrimarySkillRound(Integer round);
     List<Employee> getEmployeesOnSecondarySkillRound(Integer round);
     List<Employee> getEmployeesOnTertiarySkillRound(Integer round);
     List<Employee> getEmployeesOnPrimarySkillAndPrimarySkillRound(String skill, Integer round);
     List<Employee> getEmployeesOnSecondarySkillAndSecondarySkillRound(String skill, Integer round);
     List<Employee> getEmployeesOnTertiarySkillAndTertiarySkillRound(String skill, Integer round);
}

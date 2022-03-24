package com.accolitedigital.iTracker.repository;

import com.accolitedigital.iTracker.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByEmployeeName(String employeeName);
    List<Employee> findByPrimarySkill(String primarySkill);
    List<Employee> findBySecondarySkill(String secondarySkill);
    List<Employee> findByTertiarySkill(String tertiarySkill);
    List<Employee> findByPrimaryRound(Integer primarySkillRound);
    List<Employee> findBySecondaryRound(Integer secondarySkillRound);
    List<Employee> findByTertiaryRound(Integer tertiarySkillRound);
    List<Employee> findByPrimarySkillAndPrimaryRound(String primarySkill,Integer round);
    List<Employee> findBySecondarySkillAndSecondaryRound(String secondarySkill,Integer round);
    List<Employee> findByTertiarySkillAndTertiaryRound(String tertiarySkill,Integer round);
}

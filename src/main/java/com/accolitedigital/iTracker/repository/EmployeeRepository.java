package com.accolitedigital.iTracker.repository;

import com.accolitedigital.iTracker.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByPrimarySkill(String primarySkill);
    List<Employee> findBySecondarySkill(String secondarySkill);
    List<Employee> findByTertiarySkill(String tertiarySkill);
    List<Employee> findByPrimaryRound(Integer primaryRound);
    List<Employee> findBySecondaryRound(Integer secondaryRound);
    List<Employee> findByTertiaryRound(Integer tertiaryRound);
    List<Employee> findByPrimarySkillAndPrimaryRound(String primarySkill,Integer primaryRound);
    List<Employee> findBySecondarySkillAndSecondaryRound(String secondarySkill,Integer secondaryRound);
    List<Employee> findByTertiarySkillAndTertiaryRound(String tertiarySkill,Integer tertiaryRound);
}

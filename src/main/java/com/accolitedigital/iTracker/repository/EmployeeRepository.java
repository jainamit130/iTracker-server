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
    List<Employee> findByPrimaryRound(Integer primarySkillRound);
    List<Employee> findBySecondaryRound(Integer secondarySkillRound);
    List<Employee> findByTertiaryRound(Integer tertiarySkillRound);
    List<Employee> findByPrimarySkillAndPrimaryRound(String primarySkill,Integer primarySkillRound);
    List<Employee> findByPrimarySkillAndSecondaryRound(String primarySkill,Integer secondarySkillRound);
    List<Employee> findByPrimarySkillAndTertiaryRound(String primarySkill,Integer tertiarySkillRound);
    List<Employee> findBySecondarySkillAndPrimaryRound(String secondarySkill,Integer primarySkillRound);
    List<Employee> findBySecondarySkillAndSecondaryRound(String secondarySkill,Integer secondarySkillRound);
    List<Employee> findBySecondarySkillAndTertiaryRound(String secondarySkill,Integer tertiarySkillRound);
    List<Employee> findByTertiarySkillAndPrimaryRound(String tertiarySkill,Integer primarySkillRound);
    List<Employee> findByTertiarySkillAndSecondaryRound(String tertiarySkill,Integer secondarySkillRound);
    List<Employee> findByTertiarySkillAndTertiaryRound(String tertiarySkill,Integer tertiarySkillRound);
}

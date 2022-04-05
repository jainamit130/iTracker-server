package com.accolitedigital.iTracker.repository;

import com.accolitedigital.iTracker.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview,Integer> {
    List<Interview> findByEmail(String email);
    @Query("SELECT i FROM Interview i WHERE (:skill is null or i.skill = :skill) and (:round is null or i.round = :round) and (i.startDate between :startDate and :endDate)")
    List<Interview> findBySkillAndRoundAndStartDateBetween(@Param("skill")String skill, @Param("round") String round, @Param("startDate") Long startDate, @Param("endDate") Long endDate);
}

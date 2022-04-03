package com.accolitedigital.iTracker.repository;

import com.accolitedigital.iTracker.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview,Integer> {
    List<Interview> findByEmail(String email);
    List<Interview> findByDateBetween(Long startDate,Long endDate);
}

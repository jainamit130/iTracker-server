package com.accolitedigital.iTracker.repository;

import com.accolitedigital.iTracker.model.Turbohire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurboRepository  extends JpaRepository<Turbohire,String> {
    List<Turbohire> findByInterviewers(String interviewers);
    List<Turbohire> findByInterviewersAndDateTimeInMilliBetween
            (String interviewers,Long startDate, Long endDate);
}

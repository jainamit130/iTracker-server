package com.accolitedigital.iTracker.repository;

import com.accolitedigital.iTracker.model.Turbohire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface TurboRepository  extends JpaRepository<Turbohire,String> {
    List<Turbohire> findByInterviewersAndDateTimeInMilliBetween
            (String interviewers,Long startDate, Long endDate);
    Boolean existsByInterviewers(String interviewers);
}

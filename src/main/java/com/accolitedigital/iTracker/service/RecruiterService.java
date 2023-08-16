package com.accolitedigital.iTracker.service;
import com.accolitedigital.iTracker.model.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class RecruiterService {

    @Autowired
    private InterviewService interviewService;

    public List<Interview> filter(String skill, String round, Long startDate, Long endDate) {
        if(startDate==null && endDate==null) {
            LocalDateTime now = LocalDateTime.now();
            startDate= now.toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
            endDate=now.plusDays(1).toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
            return interviewService.getInterviewsOnSkillAndRound(skill, round, startDate, endDate);
        }
        return interviewService.getInterviewsOnSkillAndRound(skill,round,startDate,endDate);
    }
}

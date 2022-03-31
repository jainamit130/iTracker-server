package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Interview;

import java.util.List;

public interface InterviewService {
    Interview saveInterview(Interview interview);
    List<Interview> getAllInterviews();
    Interview updateInterview(Integer id, Interview interview);
    void deleteInterview(Integer id);
    List<Interview> getTodayInterviews();
    List<Interview> getInterviewsBetweenGivenRange(Long startDate, Long endDate);
    List<Interview> getInterviewsFromName(String name);
}

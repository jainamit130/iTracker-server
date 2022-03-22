package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Interview;

import java.util.List;

public interface InterviewService {
    public Interview saveInterview(Interview interview);
    public List<Interview> getAllInterviews();
    public Interview getInterview(Integer id);
    public Interview updateInterview(Integer id, Interview interview);
    public void deleteInterview(Integer id);
    public List<Interview> getTodayInterviews();
    public List<Interview> getInterviewsBetweenGivenRange(String startDate, String endDate);
    public List<Interview> getInterviewsFromName(String name);
}

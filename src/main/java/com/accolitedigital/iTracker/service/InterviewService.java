package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Interview;

import java.util.List;

public interface InterviewService {
    void saveInterview(Interview interviews);
    List<Interview> getAllInterviews();
    void updateInterview(Interview interview);
    void deleteInterview(Integer id);
    List<Interview> getInterviewsFromName(String name);
    List<Interview> getInterviewsOnSkillAndRound(String skill, String round,Long startDate,Long endDate);
}

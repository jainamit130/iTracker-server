package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Interview;

import java.util.List;

public interface InterviewService {
    Integer saveInterview(Interview interviews);
    List<Interview> getAllInterviews();
    Integer updateInterview(Interview interview);
    void deleteInterview(Integer id);
    List<Interview> getInterviewsFromEmail(String email);
    List<Interview> getInterviewsOnSkillAndRound
            (String skill, String round,Long startDate,Long endDate);
    void saveAllInterviews(List<Interview> interviews);
}

package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Interview;
import com.accolitedigital.iTracker.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;
    @Autowired
    private InterviewValidationService interviewValidationService;

    @Override
    public Integer saveInterview(Interview interview) {
        if(interviewValidationService.slotRangeValidation(interview)==0)
            return interviewValidationService.getStatus();
        List<Interview> interviews=interviewValidationService.slotDivision(interview);
        if(interviewValidationService.slotOverlapValidation(interviews)==1)
            interviewRepository.saveAll(interviews);
        return interviewValidationService.getStatus();
    }

    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    @Override
    public Integer updateInterview(Interview updatedInterview){
        updatedInterview=interviewValidationService.setSlotEmployee(updatedInterview);
        if(interviewValidationService.slotRangeValidation(updatedInterview)==0)
            return interviewValidationService.getStatus();
        if (interviewValidationService.slotOverlapValidation(Arrays.asList(updatedInterview))==1)
            interviewRepository.save(updatedInterview);
        return interviewValidationService.getStatus();
    }

    @Override
    public void deleteInterview(Integer id){
        interviewRepository.deleteById(id); }

    @Override
    public List<Interview> getInterviewsFromEmail(String name) {
        return interviewRepository.findByEmail(name);
    }

    @Override
    public List<Interview> getInterviewsOnSkillAndRound(String skill, String round,Long startDate,Long endDate) {
        return interviewRepository.findBySkillAndRoundAndStartDateBetween(skill,round,startDate,endDate);
    }

    @Override
    public void saveAllInterviews(List<Interview> interviews) {
        for (Interview interview:interviews)
            this.saveInterview(interview);
    }

}
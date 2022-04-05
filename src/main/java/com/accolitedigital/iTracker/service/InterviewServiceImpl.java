package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Interview;
import com.accolitedigital.iTracker.repository.EmployeeRepository;
import com.accolitedigital.iTracker.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void saveInterview(Interview interview) {
        List<Interview> interviews=new ArrayList<>();
        interview.setEmployee(employeeRepository.findByEmail(interview.getEmail()));
        if(!interview.getRecurringType()){
            interview.setStartDate(interview.getStartDate());
            while(interview.getStartDate()<interview.getEndDate()){
                Interview newInstance=new Interview(interview);
                newInstance.setEndDate(newInstance.getStartDate()+3600000);
                interviews.add(newInstance);
                interview.setStartDate(interview.getStartDate()+(86400000*7));
            }
        }
        else{
            interview.setStartDate(interview.getStartDate());
            while(interview.getStartDate()<interview.getEndDate()){
                Interview newInstance=new Interview(interview);
                newInstance.setEndDate(newInstance.getStartDate()+3600000);
                interviews.add(newInstance);
                interview.setStartDate(interview.getStartDate()+86400000);
            }
        }
        interviewRepository.saveAll(interviews);
    }

    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    @Override
    public void updateInterview(Interview updatedInterview){
        updatedInterview.setEmployee(employeeRepository.findByEmail(updatedInterview.getEmail()));
        interviewRepository.save(updatedInterview);
    }

    @Override
    public void deleteInterview(Integer id){
        interviewRepository.deleteById(id); }

    @Override
    public List<Interview> getInterviewsFromName(String name) {
        return interviewRepository.findByEmail(name);
    }

    @Override
    public List<Interview> getInterviewsOnSkillAndRound(String skill, String round,Long startDate,Long endDate) {
        return interviewRepository.findBySkillAndRoundAndStartDateBetween(skill,round,startDate,endDate);
    }

}
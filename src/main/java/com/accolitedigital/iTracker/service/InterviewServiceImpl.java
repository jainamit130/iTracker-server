package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Interview;
import com.accolitedigital.iTracker.repository.EmployeeRepository;
import com.accolitedigital.iTracker.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Interview saveInterview(Interview interview) {
        interview.setEmployee(employeeRepository.findByEmployeeName(interview.getName()));
        return interviewRepository.save(interview);
    }

    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    @Override
    public Interview updateInterview(Integer id, Interview updatedInterview){
        return interviewRepository.save(updatedInterview);
    }

    @Override
    public void deleteInterview(Integer id){
        interviewRepository.deleteById(id); }

    @Override
    public List<Interview> getTodayInterviews() {
        LocalDateTime now = LocalDateTime.now();
        long startDate= now.toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
        long endDate=now.plusDays(1).toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
        return interviewRepository.findByDateBetween(startDate,endDate);
    }

    @Override
    public List<Interview> getInterviewsBetweenGivenRange(Long startDate, Long endDate) {
        return interviewRepository.findByDateBetween(startDate,endDate);
    }

    @Override
    public List<Interview> getInterviewsFromName(String name) {
        return interviewRepository.findByName(name);
    }

}
package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Interview;
import com.accolitedigital.iTracker.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    @Override
    public Interview saveInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    @Override
    public  Interview getInterview(Integer id) { return interviewRepository.findById(id).get();}

    @Override
    public Interview updateInterview(Integer id, Interview updatedInterview){
        return interviewRepository.save(updatedInterview);
    }

    @Override
    public void deleteInterview(Integer id){
        interviewRepository.deleteById(id); }

    @Override
    public List<Interview> getTodayInterviews() {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        return interviewRepository.findByDate(currentDate);
    }

    @Override
    public List<Interview> getInterviewsBetweenGivenRange(String startDate, String endDate) {
        return interviewRepository.findByDateBetween(startDate+"T00:00:00.000Z",endDate+"T23:59:59.999Z");
    }

    @Override
    public List<Interview> getInterviewsFromName(String name) {
        return interviewRepository.findByName(name);
    }

}
package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Interview;
import com.accolitedigital.iTracker.repository.EmployeeRepository;
import com.accolitedigital.iTracker.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Service
public class InterviewValidationService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private InterviewRepository interviewRepository;

    private Integer status;

    public InterviewValidationService() {
        this.status = 0;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer slotRangeValidation(Interview interview){

        Calendar now1= Calendar.getInstance();
        now1.add(Calendar.DATE, +14);

        Calendar now2= Calendar.getInstance();
        now2.add(Calendar.DATE,+44);

        if(interview.getStartDate()< now2.getTimeInMillis() && interview.getStartDate()> now1.getTimeInMillis())
            this.status=1;

        return status;
    }

    public Integer slotOverlapValidation(List<Interview> interviews){
        List<Interview> bookedInterviews = interviewRepository.findByEmail(interviews.get(0).getEmail());
        for (Interview interview:interviews) {
            for (Interview eachBookedInterview : bookedInterviews) {
                if(eachBookedInterview.getId()!=interview.getId()) {
                    if (eachBookedInterview.getStartDate() < interview.getStartDate() && interview.getStartDate() < eachBookedInterview.getEndDate() && eachBookedInterview.getId() != interview.getId())
                        status = -1;
                    else if (eachBookedInterview.getStartDate() < interview.getEndDate() && interview.getEndDate() < eachBookedInterview.getEndDate())
                        status = -1;
                    else if ((Objects.equals(eachBookedInterview.getStartDate(), interview.getStartDate())) && (Objects.equals(interview.getEndDate(), eachBookedInterview.getEndDate())))
                        status = -1;
                    else if (interview.getStartDate()<=eachBookedInterview.getStartDate() && interview.getEndDate()>= eachBookedInterview.getEndDate())
                        status = -1;
                }

                if(status==-1)
                    return status;
            }
        }
        return status;
    }

    public List<Interview> slotDivision(Interview interview){
        List<Interview> interviews=new ArrayList<>();
        interview.setEmployee(employeeRepository.findByEmail(interview.getEmail()));
        if(!interview.getRecurringType()){
            while(interview.getStartDate()<interview.getEndDate()){
                Interview newInstance=new Interview(interview);
                newInstance.setEndDate(newInstance.getStartDate()+3600000);
                interviews.add(newInstance);
                interview.setStartDate(interview.getStartDate()+(86400000*7));
            }
        }
        else{
            while(interview.getStartDate()<interview.getEndDate()){
                Interview newInstance=new Interview(interview);
                newInstance.setEndDate(newInstance.getStartDate()+3600000);
                interviews.add(newInstance);
                interview.setStartDate(interview.getStartDate()+86400000);
            }
        }
        return interviews;
    }

    public Interview setSlotEmployee(Interview interview){
        interview.setEmployee(employeeRepository.findByEmail(interview.getEmail()));
        return interview;
    }
}

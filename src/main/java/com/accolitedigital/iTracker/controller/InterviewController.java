package com.accolitedigital.iTracker.controller;

import com.accolitedigital.iTracker.model.Interview;
import com.accolitedigital.iTracker.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/slotView")
@CrossOrigin
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    @PostMapping("/add")
    public String add(@RequestBody Interview interview) throws ParseException {

        Calendar now1= Calendar.getInstance();
        now1.add(Calendar.DATE, +14);

        Calendar now2= Calendar.getInstance();
        now2.add(Calendar.DATE,+44);

        if(interview.getDate()< now2.getTimeInMillis() && interview.getDate()> now1.getTimeInMillis()) {
            interviewService.saveInterview(interview);
            return "New interview is added";
        }
        else
            return "Possible Slot is only for 30 days beyond 2 weeks";
    }

    @GetMapping("/getAll")
    public List<Interview> list(){
        return interviewService.getAllInterviews();
    }

    @GetMapping("/get")
    public List<Interview> basedOnName(@RequestHeader String name){ return interviewService.getInterviewsFromName(name);}

    @GetMapping("/")
    public List<Interview> todaysInterview(){ return interviewService.getTodayInterviews(); }

    @GetMapping("/interviewsBasedOnDate")
    public List<Interview> interviewsInGivenRange(@RequestHeader Long startDate,@RequestHeader Long endDate){
        return interviewService.getInterviewsBetweenGivenRange(startDate,endDate);
    }

    @PutMapping("/update")
    public String update(@RequestHeader Integer id,@RequestBody Interview interview){
        interviewService.updateInterview(id,interview);
        return "Interview Slot with id "+id+" is now updated!";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestHeader Integer id){
        interviewService.deleteInterview(id);
        return "Interview Slot with id "+id+" is deleted!";
    }

}
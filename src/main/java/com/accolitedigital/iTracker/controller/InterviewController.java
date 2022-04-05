package com.accolitedigital.iTracker.controller;

import com.accolitedigital.iTracker.model.Interview;
import com.accolitedigital.iTracker.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/slotView")
@CrossOrigin(origins = "http://ec2-15-206-211-127.ap-south-1.compute.amazonaws.com:8080")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    @PostMapping("/add")
    public String add(@RequestBody Interview interview) {

        Calendar now1= Calendar.getInstance();
        now1.add(Calendar.DATE, +14);

        Calendar now2= Calendar.getInstance();
        now2.add(Calendar.DATE,+44);

        if(interview.getStartDate()< now2.getTimeInMillis() && interview.getStartDate()> now1.getTimeInMillis()) {
            interviewService.saveInterview(interview);
            return "New interview is added";
        }
        else
            return "Possible Slot is only for 30 days beyond 2 weeks";
    }

    //only used in postman for testing...is not used in UI
    @GetMapping("/getAll")
    public List<Interview> list(){
        return interviewService.getAllInterviews();
    }

    @GetMapping("/get")
    public List<Interview> basedOnName(@RequestParam String email){ return interviewService.getInterviewsFromName(email);}

    @PutMapping("/update")
    public String update(@RequestBody Interview interview){
        interviewService.updateInterview(interview);
        return "Interview Slot with id "+interview.getId()+" is now updated!";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Integer id){
        interviewService.deleteInterview(id);
        return "Interview Slot with id "+id+" is deleted!";
    }

}
package com.accolitedigital.iTracker.controller;

import com.accolitedigital.iTracker.model.Interview;
import com.accolitedigital.iTracker.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/slotView")
@CrossOrigin
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    @PostMapping("/add")
    public String add(@RequestBody Interview interview) throws ParseException {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

        Calendar now1= Calendar.getInstance();
        now1.add(Calendar.DATE, +14);
        String possibleSlotStartString=dateFormat.format(now1.getTime());
        Date possibleSlotStart=dateFormat.parse(possibleSlotStartString);

        Calendar now2= Calendar.getInstance();
        now2.add(Calendar.DATE,+44);
        String possibleEndSlotString=dateFormat.format(now2.getTime());
        Date possibleEndSlot=dateFormat.parse(possibleEndSlotString);

        Date interviewStartDate=dateFormat.parse(interview.getDate());

        if(interviewStartDate.before(possibleEndSlot) && interviewStartDate.after(possibleSlotStart)) {
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

    @GetMapping("/{id}")
    public Interview basedOnId(@PathVariable Integer id){ return interviewService.getInterview(id);}

    @GetMapping("/InterviewsToday")
    public List<Interview> todaysInterview(){ return interviewService.getTodayInterviews(); }

    @GetMapping("/startDate={startDate}&endDate={endDate}")
    public List<Interview> interviewsInGivenRange(@PathVariable String startDate,@PathVariable String endDate){
        return interviewService.getInterviewsBetweenGivenRange(startDate,endDate);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Integer id,@RequestBody Interview interview){
        interviewService.updateInterview(id,interview);
        return "Interview Slot with "+id+" is now updated!";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        interviewService.deleteInterview(id);
        return "Interview Slot with id "+id+" is deleted!";
    }

}
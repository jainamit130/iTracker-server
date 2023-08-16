package com.accolitedigital.iTracker.controller;

import com.accolitedigital.iTracker.model.Interview;
import com.accolitedigital.iTracker.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slotView")
@CrossOrigin(origins = "*")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    @PostMapping("/add")
    public String add(@RequestBody Interview interview) {
        return "{\"status\":"+interviewService.saveInterview(interview)+"}";
    }

    @PostMapping("/addAll")
    public String addAll(@RequestBody List<Interview> interviews){
        interviewService.saveAllInterviews(interviews);
        return "All Interviews added";
    }

    @GetMapping("/getAll")
    public List<Interview> list(){
        return interviewService.getAllInterviews();
    }

    @GetMapping("/get")
    public List<Interview> basedOnEmail(@RequestParam String email){ return interviewService.getInterviewsFromEmail(email);}

    @PutMapping("/update")
    public String update(@RequestBody Interview interview){
        return "{\"status\":"+interviewService.updateInterview(interview)+"}";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Integer id){
        interviewService.deleteInterview(id);
        return "{\"status\":"+1+"}";
    }

}
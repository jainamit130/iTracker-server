package com.accolitedigital.iTracker.controller;

import com.accolitedigital.iTracker.model.Interview;
import com.accolitedigital.iTracker.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recruiterView")
@CrossOrigin
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;
    List<Interview> interviews=new ArrayList<>();

    @GetMapping("/get/{skillType}/skill={skill}")
    public List<Interview> employeesOnSkill(@PathVariable String skillType,@PathVariable String skill){
        interviews= recruiterService.getInterviewsOnSkill(skill,skillType);
        return interviews;
    }

    @GetMapping("/get/{skillType}/round={round}")
    public List<Interview> employeesOnRound(@PathVariable String skillType,@PathVariable Integer round){
        interviews= recruiterService.getInterviewsOnRound(round,skillType);
        return interviews;
    }

    @GetMapping("/get/{skillType}/skill={skill}/round={round}")
    public List<Interview> employeesOnSkillAndRound(@PathVariable String skillType,@PathVariable String skill,@PathVariable Integer round){
        interviews= recruiterService.getInterviewsOnSkillAndRound(skillType,skill,round);
        return interviews;
    }

    @GetMapping("download/csv")
    public void downloadCSV(HttpServletResponse response) throws IOException, ParseException {
        response.setContentType("text/csv");
        response.setHeader("Content:disposition","application;attachment:interview.csv");
        recruiterService.downloadCSVFile(response.getWriter(),interviews);
    }

}

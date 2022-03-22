package com.accolitedigital.iTracker.controller;

import com.accolitedigital.iTracker.model.Interview;
import com.accolitedigital.iTracker.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruiterView")
@CrossOrigin
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @GetMapping("/get/{skillType}/skill={skill}")
    public List<Interview> employeesOnSkill(@PathVariable String skillType,@PathVariable String skill){
        return recruiterService.getInterviewsOnSkill(skill,skillType);
    }

    @GetMapping("/get/{skillType}/round={round}")
    public List<Interview> employeesOnRound(@PathVariable String skillType,@PathVariable Integer round){
        return recruiterService.getInterviewsOnRound(round,skillType);
    }

    @GetMapping("/get/{skillType}/skill={skill}/round={round}")
    public List<Interview> employeesOnSkillAndRound(@PathVariable String skillType,@PathVariable String skill,@PathVariable Integer round){
        return recruiterService.getInterviewsOnSkillAndRound(skillType,skill,round);
    }
}

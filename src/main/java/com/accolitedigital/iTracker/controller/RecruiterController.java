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

    @GetMapping("/get/filterPrimarySkill/{primarySkill}")
    public List<Interview> employeesOnPrimarySkill(@PathVariable String primarySkill){
        return recruiterService.skillFilter(primarySkill,1);
    }

    @GetMapping("/get/filterSecondarySkill/{secondarySkill}")
    public List<Interview> employeesOnSecondarySkill(@PathVariable String secondarySkill){
        return recruiterService.skillFilter(secondarySkill,2);
    }

    @GetMapping("/get/filterTertiarySkill/{tertiarySkill}")
    public List<Interview> employeesOnTertiarySkill(@PathVariable String tertiarySkill){
        return recruiterService.skillFilter(tertiarySkill,3);
    }

    @GetMapping("/get/filterPrimarySkillRound/{primarySkillRound}")
    public List<Interview> employeesOnPrimarySkillRound(@PathVariable Integer primarySkillRound){
        return recruiterService.roundFilter(primarySkillRound,1);
    }

    @GetMapping("/get/filterSecondarySkillRound/{secondarySkillRound}")
    public List<Interview> employeesOnSecondarySkillRound(@PathVariable Integer secondarySkillRound){
        return recruiterService.roundFilter(secondarySkillRound,2);
    }

    @GetMapping("/get/filterTertiarySkillRound/{tertiarySkillRound}")
    public List<Interview> employeesOnTertiarySkillRound(@PathVariable Integer tertiarySkillRound){
        return recruiterService.roundFilter(tertiarySkillRound,3);
    }

    @GetMapping("/get/filterPrimarySkillAndRound/{skill}&{round}")
    public List<Interview> employeesOnPrimarySkillAndSkillRound(@PathVariable String skill,@PathVariable Integer round){
            return recruiterService.skillAndRoundFilter(skill, 1, round);
    }

    @GetMapping("/get/filterSecondarySkillAndRound/{skill}&{round}")
    public List<Interview> employeesOnSecondarySkillAndSkillRound(@PathVariable String skill,@PathVariable Integer round){
            return recruiterService.skillAndRoundFilter(skill,2,round);
    }

    @GetMapping("/get/filterTertiarySkillAndRound/{skill}&{round}")
    public List<Interview> employeesOnTertiarySkillAndSkillRound(@PathVariable String skill,@PathVariable Integer round){
            return recruiterService.skillAndRoundFilter(skill,3,round);
    }

}

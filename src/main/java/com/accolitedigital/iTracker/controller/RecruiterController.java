package com.accolitedigital.iTracker.controller;

import com.accolitedigital.iTracker.model.Interview;
import com.accolitedigital.iTracker.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruiterView")
@CrossOrigin(origins = "*")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @GetMapping("/get")
    public List<Interview> filters(@RequestParam(required = false) String skill,@RequestParam(required = false) String round,@RequestParam(required = false) Long startDate,@RequestParam(required = false) Long endDate){
        return recruiterService.filter(skill,round,startDate,endDate);
    }
}

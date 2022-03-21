package com.accolitedigital.iTracker.controller;

import com.accolitedigital.iTracker.model.Employee;
import com.accolitedigital.iTracker.model.Interview;
import com.accolitedigital.iTracker.service.EmployeeService;
import com.accolitedigital.iTracker.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recruiterView")
@CrossOrigin
public class RecruiterController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private InterviewService interviewService;

    @GetMapping("/get/primarySkill/{primarySkill}")
    public List<Interview> employeesOnPrimarySkill(@PathVariable String primarySkill){
        List<Employee> employees =  employeeService.getEmployeesOnPrimarySkill(primarySkill);
        String[] interviewers = new String[employees.size()];
        List<Interview> interviews = new ArrayList<>();
        for(int i=0;i<employees.size();i++){
            interviewers[i]=employees.get(i).getEmployeeName();
            interviews.addAll(interviewService.getInterviewsFromName(interviewers[i]));
        }
        return interviews;
    }

}

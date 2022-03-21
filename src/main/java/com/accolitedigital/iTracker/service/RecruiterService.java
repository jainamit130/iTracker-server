package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Employee;
import com.accolitedigital.iTracker.model.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecruiterService {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private InterviewService interviewService;

    public List<Interview> skillFilter(String skill, Integer skillType) {
        List<Employee> employees=new ArrayList<>();
        if(skillType==1)
            employees =  employeeService.getEmployeesOnPrimarySkill(skill);
        else if(skillType==2)
            employees =  employeeService.getEmployeesOnSecondarySkill(skill);
        else if(skillType==3)
            employees =  employeeService.getEmployeesOnTertiarySkill(skill);
        String[] interviewers = new String[employees.size()];
        List<Interview> interviews = new ArrayList<>();
        for(int i=0;i<employees.size();i++){
            interviewers[i]=employees.get(i).getEmployeeName();
            interviews.addAll(interviewService.getInterviewsFromName(interviewers[i]));
        }
        return interviews;
    }

    public List<Interview> roundFilter(Integer round, Integer roundType) {
        List<Employee> employees=new ArrayList<>();
        if(roundType==1)
            employees =  employeeService.getEmployeesOnPrimarySkillRound(round);
        else if(roundType==2)
            employees =  employeeService.getEmployeesOnSecondarySkillRound(round);
        else if(roundType==3)
            employees =  employeeService.getEmployeesOnTertiarySkillRound(round);
        String[] interviewers = new String[employees.size()];
        List<Interview> interviews = new ArrayList<>();
        for(int i=0;i<employees.size();i++){
            interviewers[i]=employees.get(i).getEmployeeName();
            interviews.addAll(interviewService.getInterviewsFromName(interviewers[i]));
        }
        return interviews;
    }

    public List<Interview> skillAndRoundFilter(String skill,Integer skillType,Integer round) {
        List<Employee> employees=new ArrayList<>();
        if(skillType==1)
            employees = employeeService.getEmployeesOnPrimarySkillAndPrimarySkillRound(skill, round);
        else if(skillType==2)
            employees = employeeService.getEmployeesOnSecondarySkillAndSecondarySkillRound(skill, round);
        else if(skillType==3)
            employees =  employeeService.getEmployeesOnTertiarySkillAndTertiarySkillRound(skill,round);
        String[] interviewers = new String[employees.size()+1];
        List<Interview> interviews = new ArrayList<>();
        for(int i=0;i<employees.size();i++){
            interviewers[i]=employees.get(i).getEmployeeName();
            interviews.addAll(interviewService.getInterviewsFromName(interviewers[i]));
        }
        return interviews;
    }
}

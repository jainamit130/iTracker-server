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

    public List<Interview> getInterviewsOnSkill(String skill,String skillType) {
        List<Employee> employees=new ArrayList<>();
        if(skillType.equals("primary"))
            employees =  employeeService.getEmployeesOnPrimarySkill(skill);
        else if(skillType.equals("secondary"))
            employees =  employeeService.getEmployeesOnSecondarySkill(skill);
        else if(skillType.equals("tertiary"))
            employees =  employeeService.getEmployeesOnTertiarySkill(skill);
        String[] interviewers = new String[employees.size()];
        List<Interview> interviews = new ArrayList<>();
        for(int i=0;i<employees.size();i++){
            interviewers[i]=employees.get(i).getEmployeeName();
            interviews.addAll(interviewService.getInterviewsFromName(interviewers[i]));
        }
        return interviews;
    }

    public List<Interview> getInterviewsOnRound(Integer round, String skill) {
        List<Employee> employees=new ArrayList<>();
        if(skill.equals("primary"))
            employees =  employeeService.getEmployeesOnPrimarySkillRound(round);
        else if(skill.equals("secondary"))
            employees =  employeeService.getEmployeesOnSecondarySkillRound(round);
        else if(skill.equals("tertiary"))
            employees =  employeeService.getEmployeesOnTertiarySkillRound(round);
        String[] interviewers = new String[employees.size()];
        List<Interview> interviews = new ArrayList<>();
        for(int i=0;i<employees.size();i++){
            interviewers[i]=employees.get(i).getEmployeeName();
            interviews.addAll(interviewService.getInterviewsFromName(interviewers[i]));
        }
        return interviews;
    }

    public List<Interview> getInterviewsOnSkillAndRound(String skillType, String skill, Integer round) {
        List<Employee> employees=new ArrayList<>();
        if(skillType.equals("primary"))
            employees =  employeeService.getEmployeesOnPrimarySkillAndRound(skill,round);
        else if(skillType.equals("secondary"))
            employees =  employeeService.getEmployeesOnSecondarySkillAndRound(skill,round);
        else if(skillType.equals("tertiary"))
            employees =  employeeService.getEmployeesOnTertiarySkillAndRound(skill,round);
        String[] interviewers = new String[employees.size()];
        List<Interview> interviews = new ArrayList<>();
        for(int i=0;i<employees.size();i++){
            interviewers[i]=employees.get(i).getEmployeeName();
            interviews.addAll(interviewService.getInterviewsFromName(interviewers[i]));
        }
        return interviews;
    }
}

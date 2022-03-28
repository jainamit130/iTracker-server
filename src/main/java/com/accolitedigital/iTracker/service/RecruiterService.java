package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Employee;
import com.accolitedigital.iTracker.model.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecruiterService {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private InterviewService interviewService;
    private String skill;
    private int round;

    public List<Interview> getInterviewsOnSkill(String skill,String skillType) {
        List<Employee> employees=new ArrayList<>();
        if(skillType.equals("primary")) {
            employees = employeeService.getEmployeesOnPrimarySkill(skill);
            round=2;
        }
        else if(skillType.equals("secondary")) {
            employees = employeeService.getEmployeesOnSecondarySkill(skill);
            round=1;
        }
        else if(skillType.equals("tertiary")) {
            employees = employeeService.getEmployeesOnTertiarySkill(skill);
            round=1;
        }
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
        this.round=round;
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
        this.skill=skill;
        this.round=round;
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

    public void downloadCSVFile(PrintWriter printWriter, List<Interview> interviews) {
        printWriter.write("Date,Name,Skill,Round,Slot timings\n");
        for (Interview interview:interviews ) {
            if(interview.getEndDate()!=null){
                LocalDate startDate=LocalDate.parse(interview.getDate().substring(0,10));
                LocalDate endDate = LocalDate.parse(interview.getEndDate().substring(0,10));
                while(startDate.isBefore(endDate)){
                    printWriter.write(String.valueOf(startDate)+','+interview.getName() +','+employeeService.getEmployeeByName(interview.getName())+','+round+','+interview.getDate().substring(11,16)+'\n');
                    startDate=startDate.plusDays(7);
                }
            }
            else
                printWriter.write(interview.getDate().substring(0,10)+','+interview.getName() +','+skill+','+round+','+interview.getDate().substring(11,16)+'\n');
        }
    }
}

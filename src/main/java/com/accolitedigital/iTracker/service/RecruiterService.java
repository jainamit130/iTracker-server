package com.accolitedigital.iTracker.service;
import org.springframework.stereotype.Service;


@Service
public class RecruiterService {

//    public void downloadCSVFile(PrintWriter printWriter, List<Interview> interviews) {
//        printWriter.write("Date,Name,Skill,Round,Slot timings\n");
//        for (Interview interview:interviews ) {
//            LocalDate startDate= Instant.ofEpochMilli(interview.getDate()).atZone(ZoneId.systemDefault()).toLocalDate();
//            String time=startDate.toString().substring(11,16);
//            if(interview.getEndDate()!=null){
//                LocalDate endDate = Instant.ofEpochMilli(interview.getEndDate()).atZone(ZoneId.systemDefault()).toLocalDate();
//                while(startDate.isBefore(endDate)){
//                    printWriter.write(startDate.toString()+','+interview.getName() +','+employeeService.getEmployeeByName(interview.getName())+','+round+','+time+'\n');
//                    startDate=startDate.plusDays(7);
//                }
//            }
//            else
//                printWriter.write(startDate.toString()+','+interview.getName() +','+skill+','+round+','+time+'\n');
//        }
//    }
}

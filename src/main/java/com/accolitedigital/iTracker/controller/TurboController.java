package com.accolitedigital.iTracker.controller;

import com.accolitedigital.iTracker.model.Turbohire;
import com.accolitedigital.iTracker.service.TurboService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/turbohire")
@EnableScheduling
public class TurboController {

    public TurboController(TurboService turboService) {
        this.turboService = turboService;
    }

    private final TurboService turboService;

    @Scheduled(cron = "0 0 0 * * ?")
    @GetMapping("/load")
    public String getData() throws JsonProcessingException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();
        String endDate = dateFormat.format(date);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date currentDate = cal.getTime();
        String startDate = dateFormat.format(currentDate);

        String url="https://api.turbohire.co/api/analytics/evaluations?startDate="+startDate+"&endDate="+endDate;
        String rawJson=turboService.consumeTurboAPI(url).getBody();
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        Turbohire[] turbohires = mapper.readValue(rawJson, Turbohire[].class);
        List<Turbohire> turboList=new ArrayList<Turbohire>(List.of(turbohires));
        turboService.saveAllTurboData(turboList);
        return "All the Turbohire data is added to database!";
    }

    @GetMapping("/{interviewers}")
    public String weeklyInterviewsNo(@PathVariable String interviewers){
        long count=turboService.countWeeklyInterviews(interviewers);
        return "{\"weekly\":"+count+"}";
    }

    @GetMapping("/{interviewers}/{startDate}&{endDate}")
    public String interviewsInBetweenRange(@PathVariable String interviewers,@PathVariable String startDate,@PathVariable String endDate){
        long count=turboService.countInterviewsBetweenRange(interviewers,startDate,endDate);
        return "{\"yearToDate\":"+count+"}";
    }

    @GetMapping("/{interviewers}/currentMonth")
    public String interviewsThisMonth(@PathVariable String interviewers){
        long count=turboService.countInterviewsThisMonth(interviewers);
        return "{\"currentMonth\":"+count+"}";
    }
}

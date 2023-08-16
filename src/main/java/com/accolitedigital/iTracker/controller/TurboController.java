package com.accolitedigital.iTracker.controller;

import com.accolitedigital.iTracker.model.Stats;
import com.accolitedigital.iTracker.model.Turbohire;
import com.accolitedigital.iTracker.service.TurboService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/turbohire")
@CrossOrigin(origins = "*")
@EnableScheduling
public class TurboController {

    public TurboController(TurboService turboService) {
        this.turboService = turboService;
    }
    private final TurboService turboService;

    @Scheduled(cron = "0 0 0 * * ?")
    @GetMapping("/load")
    public String getData() throws JsonProcessingException, ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();
        String endDate = dateFormat.format(date);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date currentDate = cal.getTime();
        String startDate = dateFormat.format(currentDate);

//        String url="https://api.turbohire.co/api/analytics/evaluations?startDate="+startDate+"&endDate="+endDate;
        String url="http://localhost:3000/turbohire";
        String rawJson=turboService.consumeTurboAPI(url).getBody();
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        Turbohire[] turbohires = mapper.readValue(rawJson, Turbohire[].class);
        List<Turbohire> turboList=new ArrayList<>(List.of(turbohires));
        turboService.saveAllTurboData(turboList);
        return "All the Turbohire data is added to database!";
    }

    @GetMapping("/stats")
    public String interviewsStats(@RequestParam String email,@RequestParam(required = false)Long startDate,@RequestParam(required = false)Long endDate){
        Stats stats=turboService.countStats(email, startDate, endDate);
        return "{\"currentMonth\":"+stats.getMonthlyCount()+","+
                "\"yearToDate\":"+stats.getYearlyCount()+","+
                "\"lastQuarter\":"+stats.getQuarterlyCount()+","+
                "\"lastWeek\":"+stats.getWeeklyCount()+","+
                "\"lastMonth\":"+stats.getLastMonthCount()+","+
                "\"lastYear\":"+stats.getLastYearCount()+","+
                "\"inGivenRange\":"+stats.getRangeCount()+"}";
    }
}


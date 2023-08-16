package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Stats;
import com.accolitedigital.iTracker.model.Turbohire;
import com.accolitedigital.iTracker.repository.TurboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

@Service
public class TurboService {

    private final RestTemplate restTemplate;

    @Autowired
    public Stats stats;

    @Autowired
    public TurboService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private TurboRepository turboRepository;

    public List<Turbohire> saveAllTurboData(List<Turbohire> turbohires) throws ParseException {
        for (Turbohire turbohire:turbohires) {
            turbohire.setDateTimeInMilli(Timestamp.valueOf(turbohire.getEvaluationDateTime().substring(0,10)+" "+turbohire.getEvaluationDateTime().substring(11,19)).getTime());
        }
        return turboRepository.saveAll(turbohires);
    }


    public ResponseEntity<String> consumeTurboAPI(String url){
        HttpHeaders headers=new HttpHeaders();
        headers.set("X-API-KEY", "1E150160-9BC1-45B8-AC65-30700B8BC8F9");
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        return  restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    public Stats countStats(String interviewers,Long startDate, Long endDate)  {

        if(!turboRepository.existsByInterviewers(interviewers)){
            return stats;
        }
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        start.set(Calendar.DAY_OF_WEEK, start.getFirstDayOfWeek()+1);
        start.set(Calendar.HOUR_OF_DAY,0);
        start.set(Calendar.MINUTE,0);
        start.set(Calendar.SECOND,0);
        stats.setWeeklyCount(turboRepository.findByInterviewersAndDateTimeInMilliBetween(interviewers,start.getTimeInMillis(),end.getTimeInMillis()).stream().count());

        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.set(Calendar.DAY_OF_MONTH, 1);
        start.set(Calendar.HOUR_OF_DAY,0);
        start.set(Calendar.MINUTE,0);
        start.set(Calendar.SECOND,0);
        stats.setMonthlyCount(turboRepository.findByInterviewersAndDateTimeInMilliBetween(interviewers,start.getTimeInMillis(),end.getTimeInMillis()).stream().count());

        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.set(Calendar.DAY_OF_YEAR, 1);
        start.set(Calendar.HOUR_OF_DAY,0);
        start.set(Calendar.MINUTE,0);
        start.set(Calendar.SECOND,0);
        stats.setYearlyCount(turboRepository.findByInterviewersAndDateTimeInMilliBetween(interviewers,start.getTimeInMillis(),end.getTimeInMillis()).stream().count());

        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.set(Calendar.DAY_OF_MONTH,1);
        start.add(Calendar.MONTH, -3);
        start.set(Calendar.HOUR_OF_DAY,0);
        start.set(Calendar.MINUTE,0);
        start.set(Calendar.SECOND,0);
        stats.setQuarterlyCount(turboRepository.findByInterviewersAndDateTimeInMilliBetween(interviewers,start.getTimeInMillis(),end.getTimeInMillis()).stream().count());

        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH,-1);
        start.set(Calendar.DAY_OF_MONTH,1);
        start.set(Calendar.HOUR_OF_DAY,0);
        start.set(Calendar.MINUTE,0);
        start.set(Calendar.SECOND,0);
        end.add(Calendar.MONTH,-1);
        end.set(Calendar.DAY_OF_MONTH,end.getActualMaximum(Calendar.DATE));
        end.set(Calendar.HOUR_OF_DAY,0);
        end.set(Calendar.MINUTE,0);
        end.set(Calendar.SECOND,0);
        stats.setLastMonthCount(turboRepository.findByInterviewersAndDateTimeInMilliBetween(interviewers,start.getTimeInMillis(),end.getTimeInMillis()).stream().count());

        start=Calendar.getInstance();
        end=Calendar.getInstance();
        start.add(Calendar.YEAR,-1);
        start.set(Calendar.MONTH,0);
        start.set(Calendar.DAY_OF_MONTH,1);
        start.set(Calendar.HOUR_OF_DAY,0);
        start.set(Calendar.MINUTE,0);
        start.set(Calendar.SECOND,0);
        end.add(Calendar.YEAR,-1);
        end.set(Calendar.MONTH,11);
        end.set(Calendar.DAY_OF_MONTH,31);
        end.set(Calendar.HOUR_OF_DAY,0);
        end.set(Calendar.MINUTE,0);
        end.set(Calendar.SECOND,0);
        stats.setLastYearCount(turboRepository.findByInterviewersAndDateTimeInMilliBetween(interviewers,start.getTimeInMillis(),end.getTimeInMillis()).stream().count());

        stats.setRangeCount(0L);
        if(startDate!=null && endDate!=null) {
            stats.setRangeCount(turboRepository.findByInterviewersAndDateTimeInMilliBetween(interviewers, startDate, endDate).stream().count());
        }
        return stats;
    }
}

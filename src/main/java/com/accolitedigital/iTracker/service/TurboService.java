package com.accolitedigital.iTracker.service;

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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class TurboService {

    private final RestTemplate restTemplate;

    @Autowired
    public TurboService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private TurboRepository turboRepository;

    public List<Turbohire> saveAllTurboData(List<Turbohire> turbohires) throws ParseException {
        for (Turbohire turbohire:turbohires) {
            turbohire.setDateTimeInMilli(Timestamp.valueOf(turbohire.getEvaluationDateTime().substring(0,10)+" "+turbohire.getEvaluationDateTime().substring(11)).getTime());
        }
        return turboRepository.saveAll(turbohires);
    }


    public ResponseEntity<String> consumeTurboAPI(String url){
        HttpHeaders headers=new HttpHeaders();
        headers.set("X-API-KEY", "1E150160-9BC1-45B8-AC65-30700B8BC8F9");
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        return  restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    public long countWeeklyInterviews(String interviewers) {
        Calendar cal = Calendar.getInstance();
        Calendar now=cal;
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        return turboRepository.findByInterviewersAndDateTimeInMilliBetween(interviewers,now.getTimeInMillis(),cal.getTimeInMillis()).stream().count();
    }

    public long countInterviewsBetweenRange(String interviewers, Long startDate, Long endDate) {
        return  turboRepository.findByInterviewersAndDateTimeInMilliBetween(interviewers,startDate,endDate).stream().count();
    }

    public long countInterviewsThisMonth(String interviewer) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

        Calendar now1= Calendar.getInstance();
        Long currentDate= now1.getTimeInMillis();

        Calendar now2 = Calendar.getInstance();
        now2.set(Calendar.DAY_OF_MONTH, 1);
        Long startDate=now2.getTimeInMillis();

        return turboRepository.findByInterviewersAndDateTimeInMilliBetween(interviewer,startDate,currentDate).stream().count();
    }

    public long countInterviewsThisYear(String interviewer) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

        Calendar now1= Calendar.getInstance();
        Long currentDate= now1.getTimeInMillis();

        Calendar now2 = Calendar.getInstance();
        now2.set(Calendar.DAY_OF_YEAR, 1);
        Long startDate=now2.getTimeInMillis();

        return turboRepository.findByInterviewersAndDateTimeInMilliBetween(interviewer,startDate,currentDate).stream().count();
    }

    public long countInterviewsLastQuarter(String interviewer) {

        Calendar now1= Calendar.getInstance();
        Long currentDate= now1.getTimeInMillis();

        Calendar now2 = Calendar.getInstance();
        now2.add(Calendar.MONTH, -4);
        Long startDate=now2.getTimeInMillis();

        return turboRepository.findByInterviewersAndDateTimeInMilliBetween(interviewer,startDate,currentDate).stream().count();
    }
}

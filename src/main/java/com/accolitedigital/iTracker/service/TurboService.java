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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    public List<Turbohire> saveAllTurboData(List<Turbohire> turbohires){
        return turboRepository.saveAll(turbohires);
    }


    public ResponseEntity<String> consumeTurboAPI(String url){
        HttpHeaders headers=new HttpHeaders();
        headers.set("X-API-KEY", "1E150160-9BC1-45B8-AC65-30700B8BC8F9");
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        return  restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }


    public void deleteAllTurboData() {
        turboRepository.deleteAll();
    }

    public long countWeeklyInterviews(String interviewers) {
        return turboRepository.findByInterviewers(interviewers).stream().count();
    }

    public long countInterviewsBetweenRange(String interviewers, String startDate, String endDate) {
        return  turboRepository.findByInterviewersAndEvaluationDateTimeBetween(interviewers,startDate,endDate).stream().count();
    }

    public long countInterviewsThisMonth(String interviewers) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();
        String currentDate = dateFormat.format(date);

        Calendar now = Calendar.getInstance();
        now.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDateOfMonth=now.getTime();
        String startDate = dateFormat.format(firstDateOfMonth);

        return turboRepository.findByInterviewersAndEvaluationDateTimeBetween(interviewers,startDate,currentDate).stream().count();
    }
}

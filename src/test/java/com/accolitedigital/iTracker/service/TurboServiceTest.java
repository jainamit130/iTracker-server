package com.accolitedigital.iTracker.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.accolitedigital.iTracker.model.Stats;
import com.accolitedigital.iTracker.model.Turbohire;
import com.accolitedigital.iTracker.repository.TurboRepository;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {TurboService.class})
@ExtendWith(SpringExtension.class)
class TurboServiceTest {
    @MockBean
    private RestTemplate restTemplate;

    @MockBean
    private Stats stats;

    @MockBean
    private TurboRepository turboRepository;

    @Autowired
    private TurboService turboService;

    /**
     * Method under test: {@link TurboService#saveAllTurboData(List)}
     */
    @Test
    void testSaveAllTurboData() throws ParseException {
        ArrayList<Turbohire> turbohireList = new ArrayList<>();
        when(turboRepository.saveAll((Iterable<Turbohire>) any())).thenReturn(turbohireList);
        List<Turbohire> actualSaveAllTurboDataResult = turboService.saveAllTurboData(new ArrayList<>());
        assertSame(turbohireList, actualSaveAllTurboDataResult);
        assertTrue(actualSaveAllTurboDataResult.isEmpty());
        verify(turboRepository).saveAll((Iterable<Turbohire>) any());
    }

    /**
     * Method under test: {@link TurboService#saveAllTurboData(List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveAllTurboData2() throws ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.StringIndexOutOfBoundsException: begin 11, end 19, length 10
        //       at java.lang.String.checkBoundsBeginEnd(String.java:4601)
        //       at java.lang.String.substring(String.java:2704)
        //       at com.accolitedigital.iTracker.service.TurboService.saveAllTurboData(TurboService.java:37)
        //   In order to prevent saveAllTurboData(List)
        //   from throwing StringIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   saveAllTurboData(List).
        //   See https://diff.blue/R013 to resolve this issue.

        when(turboRepository.saveAll((Iterable<Turbohire>) any())).thenReturn(new ArrayList<>());

        Turbohire turbohire = new Turbohire();
        turbohire.setApplicantName("Applicant Name");
        turbohire.setCategory("Category");
        turbohire.setDateTimeInMilli(1L);
        turbohire.setEvaluationDateTime("2020-03-01");
        turbohire.setInterviewers("Interviewers");
        turbohire.setJobStage("Job Stage");
        turbohire.setRecordId("42");

        ArrayList<Turbohire> turbohireList = new ArrayList<>();
        turbohireList.add(turbohire);
        turboService.saveAllTurboData(turbohireList);
    }

    /**
     * Method under test: {@link TurboService#saveAllTurboData(List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveAllTurboData3() throws ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.StringIndexOutOfBoundsException: begin 0, end 10, length 3
        //       at java.lang.String.checkBoundsBeginEnd(String.java:4601)
        //       at java.lang.String.substring(String.java:2704)
        //       at com.accolitedigital.iTracker.service.TurboService.saveAllTurboData(TurboService.java:37)
        //   In order to prevent saveAllTurboData(List)
        //   from throwing StringIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   saveAllTurboData(List).
        //   See https://diff.blue/R013 to resolve this issue.

        when(turboRepository.saveAll((Iterable<Turbohire>) any())).thenReturn(new ArrayList<>());
        Turbohire turbohire = mock(Turbohire.class);
        when(turbohire.getEvaluationDateTime()).thenReturn("foo");
        doNothing().when(turbohire).setApplicantName((String) any());
        doNothing().when(turbohire).setCategory((String) any());
        doNothing().when(turbohire).setDateTimeInMilli((Long) any());
        doNothing().when(turbohire).setEvaluationDateTime((String) any());
        doNothing().when(turbohire).setInterviewers((String) any());
        doNothing().when(turbohire).setJobStage((String) any());
        doNothing().when(turbohire).setRecordId((String) any());
        turbohire.setApplicantName("Applicant Name");
        turbohire.setCategory("Category");
        turbohire.setDateTimeInMilli(1L);
        turbohire.setEvaluationDateTime("2020-03-01");
        turbohire.setInterviewers("Interviewers");
        turbohire.setJobStage("Job Stage");
        turbohire.setRecordId("42");

        ArrayList<Turbohire> turbohireList = new ArrayList<>();
        turbohireList.add(turbohire);
        turboService.saveAllTurboData(turbohireList);
    }

    /**
     * Method under test: {@link TurboService#consumeTurboAPI(String)}
     */
    @Test
    void testConsumeTurboAPI() throws RestClientException {
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(HttpStatus.CONTINUE);
        when(restTemplate.exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(), (Class<Object>) any(),
                (Object[]) any())).thenReturn(responseEntity);
        assertSame(responseEntity, turboService.consumeTurboAPI("https://example.org/example"));
        verify(restTemplate).exchange((String) any(), (HttpMethod) any(), (HttpEntity<Object>) any(), (Class<Object>) any(),
                (Object[]) any());
    }

    /**
     * Method under test: {@link TurboService#countStats(String, Long, Long)}
     */
    @Test
    void testCountStats() {
        doNothing().when(stats).setLastMonthCount((Long) any());
        doNothing().when(stats).setLastYearCount((Long) any());
        doNothing().when(stats).setMonthlyCount((Long) any());
        doNothing().when(stats).setQuarterlyCount((Long) any());
        doNothing().when(stats).setRangeCount((Long) any());
        doNothing().when(stats).setWeeklyCount((Long) any());
        doNothing().when(stats).setYearlyCount((Long) any());
        when(turboRepository.findByInterviewersAndDateTimeInMilliBetween((String) any(), (Long) any(), (Long) any()))
                .thenReturn(new ArrayList<>());
        when(turboRepository.existsByInterviewers((String) any())).thenReturn(true);
        turboService.countStats("Interviewers", 3L, 3L);
        verify(stats).setLastMonthCount((Long) any());
        verify(stats).setLastYearCount((Long) any());
        verify(stats).setMonthlyCount((Long) any());
        verify(stats).setQuarterlyCount((Long) any());
        verify(stats, atLeast(1)).setRangeCount((Long) any());
        verify(stats).setWeeklyCount((Long) any());
        verify(stats).setYearlyCount((Long) any());
        verify(turboRepository).existsByInterviewers((String) any());
        verify(turboRepository, atLeast(1)).findByInterviewersAndDateTimeInMilliBetween((String) any(), (Long) any(),
                (Long) any());
    }

    /**
     * Method under test: {@link TurboService#countStats(String, Long, Long)}
     */
    @Test
    void testCountStats2() {
        doNothing().when(stats).setLastMonthCount((Long) any());
        doNothing().when(stats).setLastYearCount((Long) any());
        doNothing().when(stats).setMonthlyCount((Long) any());
        doNothing().when(stats).setQuarterlyCount((Long) any());
        doNothing().when(stats).setRangeCount((Long) any());
        doNothing().when(stats).setWeeklyCount((Long) any());
        doNothing().when(stats).setYearlyCount((Long) any());
        when(turboRepository.findByInterviewersAndDateTimeInMilliBetween((String) any(), (Long) any(), (Long) any()))
                .thenReturn(new ArrayList<>());
        when(turboRepository.existsByInterviewers((String) any())).thenReturn(false);
        turboService.countStats("Interviewers", 3L, 3L);
        verify(turboRepository).existsByInterviewers((String) any());
    }

    /**
     * Method under test: {@link TurboService#countStats(String, Long, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCountStats3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Boolean.booleanValue()" because the return value of "com.accolitedigital.iTracker.repository.TurboRepository.existsByInterviewers(String)" is null
        //       at com.accolitedigital.iTracker.service.TurboService.countStats(TurboService.java:52)
        //   In order to prevent countStats(String, Long, Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   countStats(String, Long, Long).
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(stats).setLastMonthCount((Long) any());
        doNothing().when(stats).setLastYearCount((Long) any());
        doNothing().when(stats).setMonthlyCount((Long) any());
        doNothing().when(stats).setQuarterlyCount((Long) any());
        doNothing().when(stats).setRangeCount((Long) any());
        doNothing().when(stats).setWeeklyCount((Long) any());
        doNothing().when(stats).setYearlyCount((Long) any());
        when(turboRepository.findByInterviewersAndDateTimeInMilliBetween((String) any(), (Long) any(), (Long) any()))
                .thenReturn(new ArrayList<>());
        when(turboRepository.existsByInterviewers((String) any())).thenReturn(null);
        turboService.countStats("Interviewers", 3L, 3L);
    }

    /**
     * Method under test: {@link TurboService#countStats(String, Long, Long)}
     */
    @Test
    void testCountStats4() {
        doNothing().when(stats).setLastMonthCount((Long) any());
        doNothing().when(stats).setLastYearCount((Long) any());
        doNothing().when(stats).setMonthlyCount((Long) any());
        doNothing().when(stats).setQuarterlyCount((Long) any());
        doNothing().when(stats).setRangeCount((Long) any());
        doNothing().when(stats).setWeeklyCount((Long) any());
        doNothing().when(stats).setYearlyCount((Long) any());
        when(turboRepository.findByInterviewersAndDateTimeInMilliBetween((String) any(), (Long) any(), (Long) any()))
                .thenReturn(new ArrayList<>());
        when(turboRepository.existsByInterviewers((String) any())).thenReturn(true);
        turboService.countStats("Interviewers", null, 3L);
        verify(stats).setLastMonthCount((Long) any());
        verify(stats).setLastYearCount((Long) any());
        verify(stats).setMonthlyCount((Long) any());
        verify(stats).setQuarterlyCount((Long) any());
        verify(stats).setRangeCount((Long) any());
        verify(stats).setWeeklyCount((Long) any());
        verify(stats).setYearlyCount((Long) any());
        verify(turboRepository).existsByInterviewers((String) any());
        verify(turboRepository, atLeast(1)).findByInterviewersAndDateTimeInMilliBetween((String) any(), (Long) any(),
                (Long) any());
    }

    /**
     * Method under test: {@link TurboService#countStats(String, Long, Long)}
     */
    @Test
    void testCountStats5() {
        doNothing().when(stats).setLastMonthCount((Long) any());
        doNothing().when(stats).setLastYearCount((Long) any());
        doNothing().when(stats).setMonthlyCount((Long) any());
        doNothing().when(stats).setQuarterlyCount((Long) any());
        doNothing().when(stats).setRangeCount((Long) any());
        doNothing().when(stats).setWeeklyCount((Long) any());
        doNothing().when(stats).setYearlyCount((Long) any());
        when(turboRepository.findByInterviewersAndDateTimeInMilliBetween((String) any(), (Long) any(), (Long) any()))
                .thenReturn(new ArrayList<>());
        when(turboRepository.existsByInterviewers((String) any())).thenReturn(true);
        turboService.countStats("Interviewers", 3L, null);
        verify(stats).setLastMonthCount((Long) any());
        verify(stats).setLastYearCount((Long) any());
        verify(stats).setMonthlyCount((Long) any());
        verify(stats).setQuarterlyCount((Long) any());
        verify(stats).setRangeCount((Long) any());
        verify(stats).setWeeklyCount((Long) any());
        verify(stats).setYearlyCount((Long) any());
        verify(turboRepository).existsByInterviewers((String) any());
        verify(turboRepository, atLeast(1)).findByInterviewersAndDateTimeInMilliBetween((String) any(), (Long) any(),
                (Long) any());
    }
}


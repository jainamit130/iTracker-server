package com.accolitedigital.iTracker.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.accolitedigital.iTracker.model.Interview;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RecruiterService.class})
@ExtendWith(SpringExtension.class)
class RecruiterServiceTest {
    @MockBean
    private InterviewService interviewService;

    @Autowired
    private RecruiterService recruiterService;

    /**
     * Method under test: {@link RecruiterService#filter(String, String, Long, Long)}
     */
    @Test
    void testFilter() {
        ArrayList<Interview> interviewList = new ArrayList<>();
        when(interviewService.getInterviewsOnSkillAndRound((String) any(), (String) any(), (Long) any(), (Long) any()))
                .thenReturn(interviewList);
        List<Interview> actualFilterResult = recruiterService.filter("Skill", "Round", 1L, 1L);
        assertSame(interviewList, actualFilterResult);
        assertTrue(actualFilterResult.isEmpty());
        verify(interviewService).getInterviewsOnSkillAndRound((String) any(), (String) any(), (Long) any(), (Long) any());
    }

    /**
     * Method under test: {@link RecruiterService#filter(String, String, Long, Long)}
     */
    @Test
    void testFilter2() {
        ArrayList<Interview> interviewList = new ArrayList<>();
        when(interviewService.getInterviewsOnSkillAndRound((String) any(), (String) any(), (Long) any(), (Long) any()))
                .thenReturn(interviewList);
        List<Interview> actualFilterResult = recruiterService.filter("Skill", "Round", null, 1L);
        assertSame(interviewList, actualFilterResult);
        assertTrue(actualFilterResult.isEmpty());
        verify(interviewService).getInterviewsOnSkillAndRound((String) any(), (String) any(), (Long) any(), (Long) any());
    }

    /**
     * Method under test: {@link RecruiterService#filter(String, String, Long, Long)}
     */
    @Test
    void testFilter3() {
        ArrayList<Interview> interviewList = new ArrayList<>();
        when(interviewService.getInterviewsOnSkillAndRound((String) any(), (String) any(), (Long) any(), (Long) any()))
                .thenReturn(interviewList);
        List<Interview> actualFilterResult = recruiterService.filter("Skill", "Round", null, null);
        assertSame(interviewList, actualFilterResult);
        assertTrue(actualFilterResult.isEmpty());
        verify(interviewService).getInterviewsOnSkillAndRound((String) any(), (String) any(), (Long) any(), (Long) any());
    }
}


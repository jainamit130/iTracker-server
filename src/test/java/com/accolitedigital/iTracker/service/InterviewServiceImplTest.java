package com.accolitedigital.iTracker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.accolitedigital.iTracker.model.Employee;
import com.accolitedigital.iTracker.model.Interview;
import com.accolitedigital.iTracker.repository.InterviewRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {InterviewServiceImpl.class})
@ExtendWith(SpringExtension.class)
class InterviewServiceImplTest {
    @MockBean
    private InterviewRepository interviewRepository;

    @Autowired
    private InterviewServiceImpl interviewServiceImpl;

    @MockBean
    private InterviewValidationService interviewValidationService;

    /**
     * Method under test: {@link InterviewServiceImpl#saveInterview(Interview)}
     */
    @Test
    void testSaveInterview() {
        when(interviewRepository.saveAll((Iterable<Interview>) any())).thenReturn(new ArrayList<>());
        when(interviewValidationService.slotOverlapValidation((List<Interview>) any())).thenReturn(1);
        when(interviewValidationService.slotDivision((Interview) any())).thenReturn(new ArrayList<>());
        when(interviewValidationService.getStatus()).thenReturn(1);
        when(interviewValidationService.slotRangeValidation((Interview) any())).thenReturn(1);

        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("Strongdg2udPassword");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());

        Interview interview = new Interview();
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee);
        interview.setEndDate(1L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(1L);
        assertEquals(1, interviewServiceImpl.saveInterview(interview).intValue());
        verify(interviewRepository).saveAll((Iterable<Interview>) any());
        verify(interviewValidationService).getStatus();
        verify(interviewValidationService).slotOverlapValidation((List<Interview>) any());
        verify(interviewValidationService).slotRangeValidation((Interview) any());
        verify(interviewValidationService).slotDivision((Interview) any());
    }

    /**
     * Method under test: {@link InterviewServiceImpl#saveInterview(Interview)}
     */
    @Test
    void testSaveInterview2() {
        when(interviewRepository.saveAll((Iterable<Interview>) any())).thenReturn(new ArrayList<>());
        when(interviewValidationService.slotOverlapValidation((List<Interview>) any())).thenReturn(0);
        when(interviewValidationService.slotDivision((Interview) any())).thenReturn(new ArrayList<>());
        when(interviewValidationService.getStatus()).thenReturn(1);
        when(interviewValidationService.slotRangeValidation((Interview) any())).thenReturn(1);

        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("Strongdg2udPassword");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());

        Interview interview = new Interview();
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee);
        interview.setEndDate(1L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(1L);
        assertEquals(1, interviewServiceImpl.saveInterview(interview).intValue());
        verify(interviewValidationService).getStatus();
        verify(interviewValidationService).slotOverlapValidation((List<Interview>) any());
        verify(interviewValidationService).slotRangeValidation((Interview) any());
        verify(interviewValidationService).slotDivision((Interview) any());
    }

    /**
     * Method under test: {@link InterviewServiceImpl#saveInterview(Interview)}
     */
    @Test
    void testSaveInterview3() {
        when(interviewRepository.saveAll((Iterable<Interview>) any())).thenReturn(new ArrayList<>());
        when(interviewValidationService.slotOverlapValidation((List<Interview>) any())).thenReturn(1);
        when(interviewValidationService.slotDivision((Interview) any())).thenReturn(new ArrayList<>());
        when(interviewValidationService.getStatus()).thenReturn(1);
        when(interviewValidationService.slotRangeValidation((Interview) any())).thenReturn(0);

        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("Strongdg2udPassword");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());

        Interview interview = new Interview();
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee);
        interview.setEndDate(1L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(1L);
        assertEquals(1, interviewServiceImpl.saveInterview(interview).intValue());
        verify(interviewValidationService).getStatus();
        verify(interviewValidationService).slotRangeValidation((Interview) any());
    }

    /**
     * Method under test: {@link InterviewServiceImpl#getAllInterviews()}
     */
    @Test
    void testGetAllInterviews() {
        ArrayList<Interview> interviewList = new ArrayList<>();
        when(interviewRepository.findAll()).thenReturn(interviewList);
        List<Interview> actualAllInterviews = interviewServiceImpl.getAllInterviews();
        assertSame(interviewList, actualAllInterviews);
        assertTrue(actualAllInterviews.isEmpty());
        verify(interviewRepository).findAll();
    }

    /**
     * Method under test: {@link InterviewServiceImpl#updateInterview(Interview)}
     */
    @Test
    void testUpdateInterview() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("Strongdg2udPassword");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());

        Interview interview = new Interview();
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee);
        interview.setEndDate(1L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(1L);
        when(interviewRepository.save((Interview) any())).thenReturn(interview);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("Strongdg2udPassword");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());

        Interview interview1 = new Interview();
        interview1.setEmail("jane.doe@example.org");
        interview1.setEmployee(employee1);
        interview1.setEndDate(1L);
        interview1.setId(1);
        interview1.setRecurringType(true);
        interview1.setRound("Round");
        interview1.setSkill("Skill");
        interview1.setStartDate(1L);
        when(interviewValidationService.slotOverlapValidation((List<Interview>) any())).thenReturn(1);
        when(interviewValidationService.setSlotEmployee((Interview) any())).thenReturn(interview1);
        when(interviewValidationService.getStatus()).thenReturn(1);
        when(interviewValidationService.slotRangeValidation((Interview) any())).thenReturn(1);

        Employee employee2 = new Employee();
        employee2.setEmail("jane.doe@example.org");
        employee2.setId(1);
        employee2.setName("Name");
        employee2.setPassword("Strongdg2udPassword");
        employee2.setPictureUrl("https://example.org/example");
        employee2.setRole("Roles");
        employee2.setSkills(new ArrayList<>());

        Interview interview2 = new Interview();
        interview2.setEmail("jane.doe@example.org");
        interview2.setEmployee(employee2);
        interview2.setEndDate(1L);
        interview2.setId(1);
        interview2.setRecurringType(true);
        interview2.setRound("Round");
        interview2.setSkill("Skill");
        interview2.setStartDate(1L);
        assertEquals(1, interviewServiceImpl.updateInterview(interview2).intValue());
        verify(interviewRepository).save((Interview) any());
        verify(interviewValidationService).setSlotEmployee((Interview) any());
        verify(interviewValidationService).getStatus();
        verify(interviewValidationService).slotOverlapValidation((List<Interview>) any());
        verify(interviewValidationService).slotRangeValidation((Interview) any());
    }

    /**
     * Method under test: {@link InterviewServiceImpl#updateInterview(Interview)}
     */
    @Test
    void testUpdateInterview2() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("Strongdg2udPassword");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());

        Interview interview = new Interview();
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee);
        interview.setEndDate(1L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(1L);
        when(interviewRepository.save((Interview) any())).thenReturn(interview);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("Strongdg2udPassword");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());

        Interview interview1 = new Interview();
        interview1.setEmail("jane.doe@example.org");
        interview1.setEmployee(employee1);
        interview1.setEndDate(1L);
        interview1.setId(1);
        interview1.setRecurringType(true);
        interview1.setRound("Round");
        interview1.setSkill("Skill");
        interview1.setStartDate(1L);
        when(interviewValidationService.slotOverlapValidation((List<Interview>) any())).thenReturn(0);
        when(interviewValidationService.setSlotEmployee((Interview) any())).thenReturn(interview1);
        when(interviewValidationService.getStatus()).thenReturn(1);
        when(interviewValidationService.slotRangeValidation((Interview) any())).thenReturn(1);

        Employee employee2 = new Employee();
        employee2.setEmail("jane.doe@example.org");
        employee2.setId(1);
        employee2.setName("Name");
        employee2.setPassword("Strongdg2udPassword");
        employee2.setPictureUrl("https://example.org/example");
        employee2.setRole("Roles");
        employee2.setSkills(new ArrayList<>());

        Interview interview2 = new Interview();
        interview2.setEmail("jane.doe@example.org");
        interview2.setEmployee(employee2);
        interview2.setEndDate(1L);
        interview2.setId(1);
        interview2.setRecurringType(true);
        interview2.setRound("Round");
        interview2.setSkill("Skill");
        interview2.setStartDate(1L);
        assertEquals(1, interviewServiceImpl.updateInterview(interview2).intValue());
        verify(interviewValidationService).setSlotEmployee((Interview) any());
        verify(interviewValidationService).getStatus();
        verify(interviewValidationService).slotOverlapValidation((List<Interview>) any());
        verify(interviewValidationService).slotRangeValidation((Interview) any());
    }

    /**
     * Method under test: {@link InterviewServiceImpl#updateInterview(Interview)}
     */
    @Test
    void testUpdateInterview3() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("Strongdg2udPassword");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());

        Interview interview = new Interview();
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee);
        interview.setEndDate(1L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(1L);
        when(interviewRepository.save((Interview) any())).thenReturn(interview);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("Strongdg2udPassword");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());

        Interview interview1 = new Interview();
        interview1.setEmail("jane.doe@example.org");
        interview1.setEmployee(employee1);
        interview1.setEndDate(1L);
        interview1.setId(1);
        interview1.setRecurringType(true);
        interview1.setRound("Round");
        interview1.setSkill("Skill");
        interview1.setStartDate(1L);
        when(interviewValidationService.slotOverlapValidation((List<Interview>) any())).thenReturn(1);
        when(interviewValidationService.setSlotEmployee((Interview) any())).thenReturn(interview1);
        when(interviewValidationService.getStatus()).thenReturn(1);
        when(interviewValidationService.slotRangeValidation((Interview) any())).thenReturn(0);

        Employee employee2 = new Employee();
        employee2.setEmail("jane.doe@example.org");
        employee2.setId(1);
        employee2.setName("Name");
        employee2.setPassword("Strongdg2udPassword");
        employee2.setPictureUrl("https://example.org/example");
        employee2.setRole("Roles");
        employee2.setSkills(new ArrayList<>());

        Interview interview2 = new Interview();
        interview2.setEmail("jane.doe@example.org");
        interview2.setEmployee(employee2);
        interview2.setEndDate(1L);
        interview2.setId(1);
        interview2.setRecurringType(true);
        interview2.setRound("Round");
        interview2.setSkill("Skill");
        interview2.setStartDate(1L);
        assertEquals(1, interviewServiceImpl.updateInterview(interview2).intValue());
        verify(interviewValidationService).setSlotEmployee((Interview) any());
        verify(interviewValidationService).getStatus();
        verify(interviewValidationService).slotRangeValidation((Interview) any());
    }

    /**
     * Method under test: {@link InterviewServiceImpl#deleteInterview(Integer)}
     */
    @Test
    void testDeleteInterview() {
        doNothing().when(interviewRepository).deleteById((Integer) any());
        interviewServiceImpl.deleteInterview(1);
        verify(interviewRepository).deleteById((Integer) any());
        assertTrue(interviewServiceImpl.getAllInterviews().isEmpty());
    }

    /**
     * Method under test: {@link InterviewServiceImpl#getInterviewsFromEmail(String)}
     */
    @Test
    void testGetInterviewsFromEmail() {
        ArrayList<Interview> interviewList = new ArrayList<>();
        when(interviewRepository.findByEmail((String) any())).thenReturn(interviewList);
        List<Interview> actualInterviewsFromEmail = interviewServiceImpl.getInterviewsFromEmail("Name");
        assertSame(interviewList, actualInterviewsFromEmail);
        assertTrue(actualInterviewsFromEmail.isEmpty());
        verify(interviewRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link InterviewServiceImpl#getInterviewsOnSkillAndRound(String, String, Long, Long)}
     */
    @Test
    void testGetInterviewsOnSkillAndRound() {
        ArrayList<Interview> interviewList = new ArrayList<>();
        when(interviewRepository.findBySkillAndRoundAndStartDateBetween((String) any(), (String) any(), (Long) any(),
                (Long) any())).thenReturn(interviewList);
        List<Interview> actualInterviewsOnSkillAndRound = interviewServiceImpl.getInterviewsOnSkillAndRound("Skill",
                "Round", 1L, 1L);
        assertSame(interviewList, actualInterviewsOnSkillAndRound);
        assertTrue(actualInterviewsOnSkillAndRound.isEmpty());
        verify(interviewRepository).findBySkillAndRoundAndStartDateBetween((String) any(), (String) any(), (Long) any(),
                (Long) any());
    }

    /**
     * Method under test: {@link InterviewServiceImpl#saveAllInterviews(List)}
     */
    @Test
    void testSaveAllInterviews() {
        interviewServiceImpl.saveAllInterviews(new ArrayList<>());
        assertTrue(interviewServiceImpl.getAllInterviews().isEmpty());
    }

    /**
     * Method under test: {@link InterviewServiceImpl#saveAllInterviews(List)}
     */
    @Test
    void testSaveAllInterviews2() {
        when(interviewRepository.saveAll((Iterable<Interview>) any())).thenReturn(new ArrayList<>());
        when(interviewValidationService.slotOverlapValidation((List<Interview>) any())).thenReturn(1);
        when(interviewValidationService.slotDivision((Interview) any())).thenReturn(new ArrayList<>());
        when(interviewValidationService.getStatus()).thenReturn(1);
        when(interviewValidationService.slotRangeValidation((Interview) any())).thenReturn(1);

        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("Strongdg2udPassword");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());

        Interview interview = new Interview();
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee);
        interview.setEndDate(1L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(1L);

        ArrayList<Interview> interviewList = new ArrayList<>();
        interviewList.add(interview);
        interviewServiceImpl.saveAllInterviews(interviewList);
        verify(interviewRepository).saveAll((Iterable<Interview>) any());
        verify(interviewValidationService).getStatus();
        verify(interviewValidationService).slotOverlapValidation((List<Interview>) any());
        verify(interviewValidationService).slotRangeValidation((Interview) any());
        verify(interviewValidationService).slotDivision((Interview) any());
        assertTrue(interviewServiceImpl.getAllInterviews().isEmpty());
    }

    /**
     * Method under test: {@link InterviewServiceImpl#saveAllInterviews(List)}
     */
    @Test
    void testSaveAllInterviews3() {
        when(interviewRepository.saveAll((Iterable<Interview>) any())).thenReturn(new ArrayList<>());
        when(interviewValidationService.slotOverlapValidation((List<Interview>) any())).thenReturn(0);
        when(interviewValidationService.slotDivision((Interview) any())).thenReturn(new ArrayList<>());
        when(interviewValidationService.getStatus()).thenReturn(1);
        when(interviewValidationService.slotRangeValidation((Interview) any())).thenReturn(1);

        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("Strongdg2udPassword");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());

        Interview interview = new Interview();
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee);
        interview.setEndDate(1L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(1L);

        ArrayList<Interview> interviewList = new ArrayList<>();
        interviewList.add(interview);
        interviewServiceImpl.saveAllInterviews(interviewList);
        verify(interviewValidationService).getStatus();
        verify(interviewValidationService).slotOverlapValidation((List<Interview>) any());
        verify(interviewValidationService).slotRangeValidation((Interview) any());
        verify(interviewValidationService).slotDivision((Interview) any());
        assertTrue(interviewServiceImpl.getAllInterviews().isEmpty());
    }

    /**
     * Method under test: {@link InterviewServiceImpl#saveAllInterviews(List)}
     */
    @Test
    void testSaveAllInterviews4() {
        when(interviewRepository.saveAll((Iterable<Interview>) any())).thenReturn(new ArrayList<>());
        when(interviewValidationService.slotOverlapValidation((List<Interview>) any())).thenReturn(1);
        when(interviewValidationService.slotDivision((Interview) any())).thenReturn(new ArrayList<>());
        when(interviewValidationService.getStatus()).thenReturn(1);
        when(interviewValidationService.slotRangeValidation((Interview) any())).thenReturn(0);

        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("Strongdg2udPassword");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());

        Interview interview = new Interview();
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee);
        interview.setEndDate(1L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(1L);

        ArrayList<Interview> interviewList = new ArrayList<>();
        interviewList.add(interview);
        interviewServiceImpl.saveAllInterviews(interviewList);
        verify(interviewValidationService).getStatus();
        verify(interviewValidationService).slotRangeValidation((Interview) any());
        assertTrue(interviewServiceImpl.getAllInterviews().isEmpty());
    }
}


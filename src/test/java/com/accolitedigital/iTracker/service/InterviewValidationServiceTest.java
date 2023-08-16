package com.accolitedigital.iTracker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.accolitedigital.iTracker.model.Employee;
import com.accolitedigital.iTracker.model.Interview;
import com.accolitedigital.iTracker.repository.EmployeeRepository;
import com.accolitedigital.iTracker.repository.InterviewRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {InterviewValidationService.class})
@ExtendWith(SpringExtension.class)
class InterviewValidationServiceTest {
    @MockBean
    private EmployeeRepository employeeRepository;

    @MockBean
    private InterviewRepository interviewRepository;

    @Autowired
    private InterviewValidationService interviewValidationService;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link InterviewValidationService}
     *   <li>{@link InterviewValidationService#getStatus()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals(0, (new InterviewValidationService()).getStatus().intValue());
    }

    /**
     * Method under test: {@link InterviewValidationService#slotRangeValidation(Interview)}
     */
    @Test
    void testSlotRangeValidation() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("iloveyou");
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
        assertEquals(0, interviewValidationService.slotRangeValidation(interview).intValue());
    }

    /**
     * Method under test: {@link InterviewValidationService#slotRangeValidation(Interview)}
     */
    @Test
    void testSlotRangeValidation2() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("iloveyou");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        Interview interview = mock(Interview.class);
        when(interview.getStartDate()).thenReturn(1L);
        doNothing().when(interview).setEmail((String) any());
        doNothing().when(interview).setEmployee((Employee) any());
        doNothing().when(interview).setEndDate((Long) any());
        doNothing().when(interview).setId(anyInt());
        doNothing().when(interview).setRecurringType((Boolean) any());
        doNothing().when(interview).setRound((String) any());
        doNothing().when(interview).setSkill((String) any());
        doNothing().when(interview).setStartDate((Long) any());
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee);
        interview.setEndDate(1L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(1L);
        assertEquals(0, interviewValidationService.slotRangeValidation(interview).intValue());
        verify(interview, atLeast(1)).getStartDate();
        verify(interview).setEmail((String) any());
        verify(interview).setEmployee((Employee) any());
        verify(interview).setEndDate((Long) any());
        verify(interview).setId(anyInt());
        verify(interview).setRecurringType((Boolean) any());
        verify(interview).setRound((String) any());
        verify(interview).setSkill((String) any());
        verify(interview).setStartDate((Long) any());
    }

    /**
     * Method under test: {@link InterviewValidationService#slotRangeValidation(Interview)}
     */
    @Test
    void testSlotRangeValidation3() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("iloveyou");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        Interview interview = mock(Interview.class);
        when(interview.getStartDate()).thenReturn(Long.MAX_VALUE);
        doNothing().when(interview).setEmail((String) any());
        doNothing().when(interview).setEmployee((Employee) any());
        doNothing().when(interview).setEndDate((Long) any());
        doNothing().when(interview).setId(anyInt());
        doNothing().when(interview).setRecurringType((Boolean) any());
        doNothing().when(interview).setRound((String) any());
        doNothing().when(interview).setSkill((String) any());
        doNothing().when(interview).setStartDate((Long) any());
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee);
        interview.setEndDate(1L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(1L);
        assertEquals(0, interviewValidationService.slotRangeValidation(interview).intValue());
        verify(interview).getStartDate();
        verify(interview).setEmail((String) any());
        verify(interview).setEmployee((Employee) any());
        verify(interview).setEndDate((Long) any());
        verify(interview).setId(anyInt());
        verify(interview).setRecurringType((Boolean) any());
        verify(interview).setRound((String) any());
        verify(interview).setSkill((String) any());
        verify(interview).setStartDate((Long) any());
    }

    /**
     * Method under test: {@link InterviewValidationService#slotOverlapValidation(List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSlotOverlapValidation() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.util.Objects.checkIndex(Objects.java:359)
        //       at java.util.ArrayList.get(ArrayList.java:427)
        //       at com.accolitedigital.iTracker.service.InterviewValidationService.slotOverlapValidation(InterviewValidationService.java:47)
        //   In order to prevent slotOverlapValidation(List)
        //   from throwing IndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   slotOverlapValidation(List).
        //   See https://diff.blue/R013 to resolve this issue.

        interviewValidationService.slotOverlapValidation(new ArrayList<>());
    }

    /**
     * Method under test: {@link InterviewValidationService#slotOverlapValidation(List)}
     */
    @Test
    void testSlotOverlapValidation2() {
        when(interviewRepository.findByEmail((String) any())).thenReturn(new ArrayList<>());

        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("iloveyou");
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
        assertEquals(0, interviewValidationService.slotOverlapValidation(interviewList).intValue());
        verify(interviewRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link InterviewValidationService#slotOverlapValidation(List)}
     */
    @Test
    void testSlotOverlapValidation3() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("iloveyou");
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
        when(interviewRepository.findByEmail((String) any())).thenReturn(interviewList);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("iloveyou");
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

        ArrayList<Interview> interviewList1 = new ArrayList<>();
        interviewList1.add(interview1);
        assertEquals(0, interviewValidationService.slotOverlapValidation(interviewList1).intValue());
        verify(interviewRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link InterviewValidationService#slotOverlapValidation(List)}
     */
    @Test
    void testSlotOverlapValidation4() {
        when(interviewRepository.findByEmail((String) any())).thenReturn(new ArrayList<>());

        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("iloveyou");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        Interview interview = mock(Interview.class);
        when(interview.getEmail()).thenReturn("jane.doe@example.org");
        doNothing().when(interview).setEmail((String) any());
        doNothing().when(interview).setEmployee((Employee) any());
        doNothing().when(interview).setEndDate((Long) any());
        doNothing().when(interview).setId(anyInt());
        doNothing().when(interview).setRecurringType((Boolean) any());
        doNothing().when(interview).setRound((String) any());
        doNothing().when(interview).setSkill((String) any());
        doNothing().when(interview).setStartDate((Long) any());
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
        assertEquals(0, interviewValidationService.slotOverlapValidation(interviewList).intValue());
        verify(interviewRepository).findByEmail((String) any());
        verify(interview).getEmail();
        verify(interview).setEmail((String) any());
        verify(interview).setEmployee((Employee) any());
        verify(interview).setEndDate((Long) any());
        verify(interview).setId(anyInt());
        verify(interview).setRecurringType((Boolean) any());
        verify(interview).setRound((String) any());
        verify(interview).setSkill((String) any());
        verify(interview).setStartDate((Long) any());
    }

    /**
     * Method under test: {@link InterviewValidationService#slotOverlapValidation(List)}
     */
    @Test
    void testSlotOverlapValidation5() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("iloveyou");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());

        Interview interview = new Interview();
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee);
        interview.setEndDate(4L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(4L);

        ArrayList<Interview> interviewList = new ArrayList<>();
        interviewList.add(interview);
        when(interviewRepository.findByEmail((String) any())).thenReturn(interviewList);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("iloveyou");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());
        Interview interview1 = mock(Interview.class);
        when(interview1.getId()).thenReturn(1);
        when(interview1.getEndDate()).thenReturn(1L);
        when(interview1.getStartDate()).thenReturn(1L);
        when(interview1.getEmail()).thenReturn("jane.doe@example.org");
        doNothing().when(interview1).setEmail((String) any());
        doNothing().when(interview1).setEmployee((Employee) any());
        doNothing().when(interview1).setEndDate((Long) any());
        doNothing().when(interview1).setId(anyInt());
        doNothing().when(interview1).setRecurringType((Boolean) any());
        doNothing().when(interview1).setRound((String) any());
        doNothing().when(interview1).setSkill((String) any());
        doNothing().when(interview1).setStartDate((Long) any());
        interview1.setEmail("jane.doe@example.org");
        interview1.setEmployee(employee1);
        interview1.setEndDate(1L);
        interview1.setId(1);
        interview1.setRecurringType(true);
        interview1.setRound("Round");
        interview1.setSkill("Skill");
        interview1.setStartDate(1L);

        ArrayList<Interview> interviewList1 = new ArrayList<>();
        interviewList1.add(interview1);
        assertEquals(0, interviewValidationService.slotOverlapValidation(interviewList1).intValue());
        verify(interviewRepository).findByEmail((String) any());
        verify(interview1).getId();
        verify(interview1).getEmail();
        verify(interview1).setEmail((String) any());
        verify(interview1).setEmployee((Employee) any());
        verify(interview1).setEndDate((Long) any());
        verify(interview1).setId(anyInt());
        verify(interview1).setRecurringType((Boolean) any());
        verify(interview1).setRound((String) any());
        verify(interview1).setSkill((String) any());
        verify(interview1).setStartDate((Long) any());
    }

    /**
     * Method under test: {@link InterviewValidationService#slotOverlapValidation(List)}
     */
    @Test
    void testSlotOverlapValidation6() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("iloveyou");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        Interview interview = mock(Interview.class);
        when(interview.getId()).thenReturn(1);
        when(interview.getEndDate()).thenReturn(1L);
        when(interview.getStartDate()).thenReturn(1L);
        doNothing().when(interview).setEmail((String) any());
        doNothing().when(interview).setEmployee((Employee) any());
        doNothing().when(interview).setEndDate((Long) any());
        doNothing().when(interview).setId(anyInt());
        doNothing().when(interview).setRecurringType((Boolean) any());
        doNothing().when(interview).setRound((String) any());
        doNothing().when(interview).setSkill((String) any());
        doNothing().when(interview).setStartDate((Long) any());
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee);
        interview.setEndDate(4L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(4L);

        ArrayList<Interview> interviewList = new ArrayList<>();
        interviewList.add(interview);
        when(interviewRepository.findByEmail((String) any())).thenReturn(interviewList);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("iloveyou");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());
        Interview interview1 = mock(Interview.class);
        when(interview1.getId()).thenReturn(1);
        when(interview1.getEndDate()).thenReturn(1L);
        when(interview1.getStartDate()).thenReturn(1L);
        when(interview1.getEmail()).thenReturn("jane.doe@example.org");
        doNothing().when(interview1).setEmail((String) any());
        doNothing().when(interview1).setEmployee((Employee) any());
        doNothing().when(interview1).setEndDate((Long) any());
        doNothing().when(interview1).setId(anyInt());
        doNothing().when(interview1).setRecurringType((Boolean) any());
        doNothing().when(interview1).setRound((String) any());
        doNothing().when(interview1).setSkill((String) any());
        doNothing().when(interview1).setStartDate((Long) any());
        interview1.setEmail("jane.doe@example.org");
        interview1.setEmployee(employee1);
        interview1.setEndDate(1L);
        interview1.setId(1);
        interview1.setRecurringType(true);
        interview1.setRound("Round");
        interview1.setSkill("Skill");
        interview1.setStartDate(1L);

        ArrayList<Interview> interviewList1 = new ArrayList<>();
        interviewList1.add(interview1);
        assertEquals(0, interviewValidationService.slotOverlapValidation(interviewList1).intValue());
        verify(interviewRepository).findByEmail((String) any());
        verify(interview).getId();
        verify(interview).setEmail((String) any());
        verify(interview).setEmployee((Employee) any());
        verify(interview).setEndDate((Long) any());
        verify(interview).setId(anyInt());
        verify(interview).setRecurringType((Boolean) any());
        verify(interview).setRound((String) any());
        verify(interview).setSkill((String) any());
        verify(interview).setStartDate((Long) any());
        verify(interview1).getId();
        verify(interview1).getEmail();
        verify(interview1).setEmail((String) any());
        verify(interview1).setEmployee((Employee) any());
        verify(interview1).setEndDate((Long) any());
        verify(interview1).setId(anyInt());
        verify(interview1).setRecurringType((Boolean) any());
        verify(interview1).setRound((String) any());
        verify(interview1).setSkill((String) any());
        verify(interview1).setStartDate((Long) any());
    }

    /**
     * Method under test: {@link InterviewValidationService#slotOverlapValidation(List)}
     */
    @Test
    void testSlotOverlapValidation7() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("iloveyou");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        Interview interview = mock(Interview.class);
        when(interview.getId()).thenReturn(4);
        when(interview.getEndDate()).thenReturn(1L);
        when(interview.getStartDate()).thenReturn(1L);
        doNothing().when(interview).setEmail((String) any());
        doNothing().when(interview).setEmployee((Employee) any());
        doNothing().when(interview).setEndDate((Long) any());
        doNothing().when(interview).setId(anyInt());
        doNothing().when(interview).setRecurringType((Boolean) any());
        doNothing().when(interview).setRound((String) any());
        doNothing().when(interview).setSkill((String) any());
        doNothing().when(interview).setStartDate((Long) any());
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee);
        interview.setEndDate(4L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(4L);

        ArrayList<Interview> interviewList = new ArrayList<>();
        interviewList.add(interview);
        when(interviewRepository.findByEmail((String) any())).thenReturn(interviewList);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("iloveyou");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());
        Interview interview1 = mock(Interview.class);
        when(interview1.getId()).thenReturn(1);
        when(interview1.getEndDate()).thenReturn(1L);
        when(interview1.getStartDate()).thenReturn(1L);
        when(interview1.getEmail()).thenReturn("jane.doe@example.org");
        doNothing().when(interview1).setEmail((String) any());
        doNothing().when(interview1).setEmployee((Employee) any());
        doNothing().when(interview1).setEndDate((Long) any());
        doNothing().when(interview1).setId(anyInt());
        doNothing().when(interview1).setRecurringType((Boolean) any());
        doNothing().when(interview1).setRound((String) any());
        doNothing().when(interview1).setSkill((String) any());
        doNothing().when(interview1).setStartDate((Long) any());
        interview1.setEmail("jane.doe@example.org");
        interview1.setEmployee(employee1);
        interview1.setEndDate(1L);
        interview1.setId(1);
        interview1.setRecurringType(true);
        interview1.setRound("Round");
        interview1.setSkill("Skill");
        interview1.setStartDate(1L);

        ArrayList<Interview> interviewList1 = new ArrayList<>();
        interviewList1.add(interview1);
        assertEquals(-1, interviewValidationService.slotOverlapValidation(interviewList1).intValue());
        verify(interviewRepository).findByEmail((String) any());
        verify(interview).getId();
        verify(interview).getEndDate();
        verify(interview, atLeast(1)).getStartDate();
        verify(interview).setEmail((String) any());
        verify(interview).setEmployee((Employee) any());
        verify(interview).setEndDate((Long) any());
        verify(interview).setId(anyInt());
        verify(interview).setRecurringType((Boolean) any());
        verify(interview).setRound((String) any());
        verify(interview).setSkill((String) any());
        verify(interview).setStartDate((Long) any());
        verify(interview1).getId();
        verify(interview1, atLeast(1)).getEndDate();
        verify(interview1, atLeast(1)).getStartDate();
        verify(interview1).getEmail();
        verify(interview1).setEmail((String) any());
        verify(interview1).setEmployee((Employee) any());
        verify(interview1).setEndDate((Long) any());
        verify(interview1).setId(anyInt());
        verify(interview1).setRecurringType((Boolean) any());
        verify(interview1).setRound((String) any());
        verify(interview1).setSkill((String) any());
        verify(interview1).setStartDate((Long) any());
        assertEquals(-1, interviewValidationService.getStatus().intValue());
    }

    /**
     * Method under test: {@link InterviewValidationService#slotOverlapValidation(List)}
     */
    @Test
    void testSlotOverlapValidation8() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("iloveyou");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        Interview interview = mock(Interview.class);
        when(interview.getId()).thenReturn(4);
        when(interview.getEndDate()).thenReturn(4L);
        when(interview.getStartDate()).thenReturn(1L);
        doNothing().when(interview).setEmail((String) any());
        doNothing().when(interview).setEmployee((Employee) any());
        doNothing().when(interview).setEndDate((Long) any());
        doNothing().when(interview).setId(anyInt());
        doNothing().when(interview).setRecurringType((Boolean) any());
        doNothing().when(interview).setRound((String) any());
        doNothing().when(interview).setSkill((String) any());
        doNothing().when(interview).setStartDate((Long) any());
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee);
        interview.setEndDate(4L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(4L);

        ArrayList<Interview> interviewList = new ArrayList<>();
        interviewList.add(interview);
        when(interviewRepository.findByEmail((String) any())).thenReturn(interviewList);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("iloveyou");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());
        Interview interview1 = mock(Interview.class);
        when(interview1.getId()).thenReturn(1);
        when(interview1.getEndDate()).thenReturn(1L);
        when(interview1.getStartDate()).thenReturn(1L);
        when(interview1.getEmail()).thenReturn("jane.doe@example.org");
        doNothing().when(interview1).setEmail((String) any());
        doNothing().when(interview1).setEmployee((Employee) any());
        doNothing().when(interview1).setEndDate((Long) any());
        doNothing().when(interview1).setId(anyInt());
        doNothing().when(interview1).setRecurringType((Boolean) any());
        doNothing().when(interview1).setRound((String) any());
        doNothing().when(interview1).setSkill((String) any());
        doNothing().when(interview1).setStartDate((Long) any());
        interview1.setEmail("jane.doe@example.org");
        interview1.setEmployee(employee1);
        interview1.setEndDate(1L);
        interview1.setId(1);
        interview1.setRecurringType(true);
        interview1.setRound("Round");
        interview1.setSkill("Skill");
        interview1.setStartDate(1L);

        ArrayList<Interview> interviewList1 = new ArrayList<>();
        interviewList1.add(interview1);
        assertEquals(0, interviewValidationService.slotOverlapValidation(interviewList1).intValue());
        verify(interviewRepository).findByEmail((String) any());
        verify(interview).getId();
        verify(interview, atLeast(1)).getEndDate();
        verify(interview, atLeast(1)).getStartDate();
        verify(interview).setEmail((String) any());
        verify(interview).setEmployee((Employee) any());
        verify(interview).setEndDate((Long) any());
        verify(interview).setId(anyInt());
        verify(interview).setRecurringType((Boolean) any());
        verify(interview).setRound((String) any());
        verify(interview).setSkill((String) any());
        verify(interview).setStartDate((Long) any());
        verify(interview1).getId();
        verify(interview1, atLeast(1)).getEndDate();
        verify(interview1, atLeast(1)).getStartDate();
        verify(interview1).getEmail();
        verify(interview1).setEmail((String) any());
        verify(interview1).setEmployee((Employee) any());
        verify(interview1).setEndDate((Long) any());
        verify(interview1).setId(anyInt());
        verify(interview1).setRecurringType((Boolean) any());
        verify(interview1).setRound((String) any());
        verify(interview1).setSkill((String) any());
        verify(interview1).setStartDate((Long) any());
    }

    /**
     * Method under test: {@link InterviewValidationService#slotDivision(Interview)}
     */
    @Test
    void testSlotDivision() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("iloveyou");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        when(employeeRepository.findByEmail((String) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("iloveyou");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());

        Interview interview = new Interview();
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee1);
        interview.setEndDate(1L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(1L);
        assertTrue(interviewValidationService.slotDivision(interview).isEmpty());
        verify(employeeRepository).findByEmail((String) any());
        assertSame(employee, interview.getEmployee());
    }

    /**
     * Method under test: {@link InterviewValidationService#slotDivision(Interview)}
     */
    @Test
    void testSlotDivision2() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("iloveyou");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        when(employeeRepository.findByEmail((String) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("iloveyou");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());
        Interview interview = mock(Interview.class);
        when(interview.getRecurringType()).thenReturn(true);
        when(interview.getEndDate()).thenReturn(1L);
        when(interview.getStartDate()).thenReturn(1L);
        when(interview.getEmail()).thenReturn("jane.doe@example.org");
        doNothing().when(interview).setEmail((String) any());
        doNothing().when(interview).setEmployee((Employee) any());
        doNothing().when(interview).setEndDate((Long) any());
        doNothing().when(interview).setId(anyInt());
        doNothing().when(interview).setRecurringType((Boolean) any());
        doNothing().when(interview).setRound((String) any());
        doNothing().when(interview).setSkill((String) any());
        doNothing().when(interview).setStartDate((Long) any());
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee1);
        interview.setEndDate(1L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(1L);
        assertTrue(interviewValidationService.slotDivision(interview).isEmpty());
        verify(employeeRepository).findByEmail((String) any());
        verify(interview).getRecurringType();
        verify(interview).getEndDate();
        verify(interview).getStartDate();
        verify(interview).getEmail();
        verify(interview).setEmail((String) any());
        verify(interview, atLeast(1)).setEmployee((Employee) any());
        verify(interview).setEndDate((Long) any());
        verify(interview).setId(anyInt());
        verify(interview).setRecurringType((Boolean) any());
        verify(interview).setRound((String) any());
        verify(interview).setSkill((String) any());
        verify(interview).setStartDate((Long) any());
    }

    /**
     * Method under test: {@link InterviewValidationService#slotDivision(Interview)}
     */
    @Test
    void testSlotDivision3() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("iloveyou");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        when(employeeRepository.findByEmail((String) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("iloveyou");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());
        Interview interview = mock(Interview.class);
        when(interview.getRecurringType()).thenReturn(false);
        when(interview.getEndDate()).thenReturn(1L);
        when(interview.getStartDate()).thenReturn(1L);
        when(interview.getEmail()).thenReturn("jane.doe@example.org");
        doNothing().when(interview).setEmail((String) any());
        doNothing().when(interview).setEmployee((Employee) any());
        doNothing().when(interview).setEndDate((Long) any());
        doNothing().when(interview).setId(anyInt());
        doNothing().when(interview).setRecurringType((Boolean) any());
        doNothing().when(interview).setRound((String) any());
        doNothing().when(interview).setSkill((String) any());
        doNothing().when(interview).setStartDate((Long) any());
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee1);
        interview.setEndDate(1L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(1L);
        assertTrue(interviewValidationService.slotDivision(interview).isEmpty());
        verify(employeeRepository).findByEmail((String) any());
        verify(interview).getRecurringType();
        verify(interview).getEndDate();
        verify(interview).getStartDate();
        verify(interview).getEmail();
        verify(interview).setEmail((String) any());
        verify(interview, atLeast(1)).setEmployee((Employee) any());
        verify(interview).setEndDate((Long) any());
        verify(interview).setId(anyInt());
        verify(interview).setRecurringType((Boolean) any());
        verify(interview).setRound((String) any());
        verify(interview).setSkill((String) any());
        verify(interview).setStartDate((Long) any());
    }

    /**
     * Method under test: {@link InterviewValidationService#setSlotEmployee(Interview)}
     */
    @Test
    void testSetSlotEmployee() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("iloveyou");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        when(employeeRepository.findByEmail((String) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("iloveyou");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());

        Interview interview = new Interview();
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee1);
        interview.setEndDate(1L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(1L);
        Interview actualSetSlotEmployeeResult = interviewValidationService.setSlotEmployee(interview);
        assertSame(interview, actualSetSlotEmployeeResult);
        assertSame(employee, actualSetSlotEmployeeResult.getEmployee());
        verify(employeeRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link InterviewValidationService#setSlotEmployee(Interview)}
     */
    @Test
    void testSetSlotEmployee2() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("iloveyou");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        when(employeeRepository.findByEmail((String) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("iloveyou");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());
        Interview interview = mock(Interview.class);
        when(interview.getEmail()).thenReturn("jane.doe@example.org");
        doNothing().when(interview).setEmail((String) any());
        doNothing().when(interview).setEmployee((Employee) any());
        doNothing().when(interview).setEndDate((Long) any());
        doNothing().when(interview).setId(anyInt());
        doNothing().when(interview).setRecurringType((Boolean) any());
        doNothing().when(interview).setRound((String) any());
        doNothing().when(interview).setSkill((String) any());
        doNothing().when(interview).setStartDate((Long) any());
        interview.setEmail("jane.doe@example.org");
        interview.setEmployee(employee1);
        interview.setEndDate(1L);
        interview.setId(1);
        interview.setRecurringType(true);
        interview.setRound("Round");
        interview.setSkill("Skill");
        interview.setStartDate(1L);
        interviewValidationService.setSlotEmployee(interview);
        verify(employeeRepository).findByEmail((String) any());
        verify(interview).getEmail();
        verify(interview).setEmail((String) any());
        verify(interview, atLeast(1)).setEmployee((Employee) any());
        verify(interview).setEndDate((Long) any());
        verify(interview).setId(anyInt());
        verify(interview).setRecurringType((Boolean) any());
        verify(interview).setRound((String) any());
        verify(interview).setSkill((String) any());
        verify(interview).setStartDate((Long) any());
    }
}


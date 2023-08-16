package com.accolitedigital.iTracker.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.accolitedigital.iTracker.exception.UserNotFoundException;
import com.accolitedigital.iTracker.model.Employee;
import com.accolitedigital.iTracker.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeServiceImpl.class})
@ExtendWith(SpringExtension.class)
class EmployeeServiceImplTest {
    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    /**
     * Method under test: {@link EmployeeServiceImpl#saveEmployee(Employee)}
     */
    @Test
    void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("kasd3udgq3wkjc");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        when(employeeRepository.save((Employee) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("kasd3udgq3wkjc");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());
        employeeServiceImpl.saveEmployee(employee1);
        verify(employeeRepository).save((Employee) any());
    }

    /**
     * Method under test: {@link EmployeeServiceImpl#saveEmployee(Employee)}
     */
    @Test
    void testSaveEmployee2() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("kasd3udgq3wkjc");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        when(employeeRepository.save((Employee) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("kasd3udgq3wkjc");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());
        employeeServiceImpl.saveEmployee(employee1);
        verify(employeeRepository).save((Employee) any());
    }

    /**
     * Method under test: {@link EmployeeServiceImpl#saveAllEmployee(List)}
     */
    @Test
    void testSaveAllEmployee() {
        employeeServiceImpl.saveAllEmployee(new ArrayList<>());
        assertTrue(employeeServiceImpl.getAllEmployees().isEmpty());
    }

    /**
     * Method under test: {@link EmployeeServiceImpl#saveAllEmployee(List)}
     */
    @Test
    void testSaveAllEmployee2() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("kasd3udgq3wkjc");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        when(employeeRepository.save((Employee) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("kasd3udgq3wkjc");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeServiceImpl.saveAllEmployee(employeeList);
        verify(employeeRepository).save((Employee) any());
    }

    /**
     * Method under test: {@link EmployeeServiceImpl#saveAllEmployee(List)}
     */
    @Test
    void testSaveAllEmployee3() {
        employeeServiceImpl.saveAllEmployee(new ArrayList<>());
        assertTrue(employeeServiceImpl.getAllEmployees().isEmpty());
    }

    /**
     * Method under test: {@link EmployeeServiceImpl#saveAllEmployee(List)}
     */
    @Test
    void testSaveAllEmployee4() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("kasd3udgq3wkjc");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        when(employeeRepository.save((Employee) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("kasd3udgq3wkjc");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeServiceImpl.saveAllEmployee(employeeList);
        verify(employeeRepository).save((Employee) any());
    }

    /**
     * Method under test: {@link EmployeeServiceImpl#getAllEmployees()}
     */
    @Test
    void testGetAllEmployees() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        when(employeeRepository.findAll()).thenReturn(employeeList);
        List<Employee> actualAllEmployees = employeeServiceImpl.getAllEmployees();
        assertSame(employeeList, actualAllEmployees);
        assertTrue(actualAllEmployees.isEmpty());
        verify(employeeRepository).findAll();
    }

    /**
     * Method under test: {@link EmployeeServiceImpl#getAllEmployees()}
     */
    @Test
    void testGetAllEmployees2() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        when(employeeRepository.findAll()).thenReturn(employeeList);
        List<Employee> actualAllEmployees = employeeServiceImpl.getAllEmployees();
        assertSame(employeeList, actualAllEmployees);
        assertTrue(actualAllEmployees.isEmpty());
        verify(employeeRepository).findAll();
    }

    /**
     * Method under test: {@link EmployeeServiceImpl#updateEmployee(Employee)}
     */
    @Test
    void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("kasd3udgq3wkjc");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        when(employeeRepository.save((Employee) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("kasd3udgq3wkjc");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());
        employeeServiceImpl.updateEmployee(employee1);
        verify(employeeRepository).save((Employee) any());
    }

    /**
     * Method under test: {@link EmployeeServiceImpl#updateEmployee(Employee)}
     */
    @Test
    void testUpdateEmployee2() {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("asfdvre5g45dsa");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        when(employeeRepository.save((Employee) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setPassword("kasd3udgq3wkjc");
        employee1.setPictureUrl("https://example.org/example");
        employee1.setRole("Roles");
        employee1.setSkills(new ArrayList<>());
        employeeServiceImpl.updateEmployee(employee1);
        verify(employeeRepository).save((Employee) any());
    }

    /**
     * Method under test: {@link EmployeeServiceImpl#deleteEmployee(Integer)}
     */
    @Test
    void testDeleteEmployee() {
        doNothing().when(employeeRepository).deleteById((Integer) any());
        employeeServiceImpl.deleteEmployee(1);
        verify(employeeRepository).deleteById((Integer) any());
        assertTrue(employeeServiceImpl.getAllEmployees().isEmpty());
    }

    /**
     * Method under test: {@link EmployeeServiceImpl#deleteEmployee(Integer)}
     */
    @Test
    void testDeleteEmployee2() {
        doNothing().when(employeeRepository).deleteById((Integer) any());
        employeeServiceImpl.deleteEmployee(1);
        verify(employeeRepository).deleteById((Integer) any());
        assertTrue(employeeServiceImpl.getAllEmployees().isEmpty());
    }

    /**
     * Method under test: {@link EmployeeServiceImpl#getEmployeeByEmail(String)}
     */
    @Test
    void testGetEmployeeByEmail() throws UserNotFoundException {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("asdadascw34fs");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        when(employeeRepository.findByEmail((String) any())).thenReturn(employee);
        assertSame(employee, employeeServiceImpl.getEmployeeByEmail("jane.doe@example.org"));
        verify(employeeRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link EmployeeServiceImpl#getEmployeeByEmail(String)}
     */
    @Test
    void testGetEmployeeByEmail2() throws UserNotFoundException {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("kasd3udgq3wkjc");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        when(employeeRepository.findByEmail((String) any())).thenReturn(employee);
        assertSame(employee, employeeServiceImpl.getEmployeeByEmail("jane.doe@example.org"));
        verify(employeeRepository).findByEmail((String) any());
    }
}


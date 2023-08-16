package com.accolitedigital.iTracker.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.accolitedigital.iTracker.model.Employee;
import com.accolitedigital.iTracker.service.EmployeeService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthController.class})
@ExtendWith(SpringExtension.class)
class AuthControllerTest {
    @Autowired
    private AuthController authController;

    @MockBean
    private EmployeeService employeeService;

    /**
     * Method under test: {@link AuthController#signIn(String, String)}
     */
    @Test
    void testSignIn() throws Exception {
        Employee employee = new Employee();
        employee.setEmail("jane.doe@example.org");
        employee.setId(1);
        employee.setName("Name");
        employee.setPassword("iloveyou");
        employee.setPictureUrl("https://example.org/example");
        employee.setRole("Roles");
        employee.setSkills(new ArrayList<>());
        when(employeeService.getEmployeeByEmail((String) any())).thenReturn(employee);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/login/get")
                .param("email", "foo")
                .param("token", "foo");
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"isUser\":true,\"role\":\"Roles\",\"profileUrl\":\"https://example.org/example\"}"));
    }
}


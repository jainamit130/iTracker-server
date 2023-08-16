package com.accolitedigital.iTracker.controller;

import com.accolitedigital.iTracker.exception.UserNotFoundException;
import com.accolitedigital.iTracker.model.Employee;
import com.accolitedigital.iTracker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get")
    public String signIn(@RequestParam String email,@RequestParam String token) throws UserNotFoundException {
        boolean status=false;
        String role="";
        String profileUrl="";
        Employee employee=employeeService.getEmployeeByEmail(email);
        if(employee!=null) {
            status = true;
            role=employee.getRole();
            profileUrl=employee.getPictureUrl();
        }
        return "{\"isUser\":" +status+","+
                "\"role\":\""+ role+"\","+
                "\"profileUrl\":\""+ profileUrl+"\"}";
    }
}

package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.model.Employee;
import com.accolitedigital.iTracker.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginDetailService implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Employee employee= employeeRepository.findByEmployeeName(userName);
        return new User(employee.getEmployeeName(),employee.getEmployeePassword(),new ArrayList<>());
    }
}

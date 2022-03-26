package com.accolitedigital.iTracker.service;

import com.accolitedigital.iTracker.config.CustomUserDetails;
import com.accolitedigital.iTracker.model.Employee;
import com.accolitedigital.iTracker.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class LoginDetailService implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByEmployeeName(userName);

        if (employee == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        CustomUserDetails user=new CustomUserDetails(employee);

        return new User(user.getUsername(),user.getPassword(),user.getAuthorities());
    }
}

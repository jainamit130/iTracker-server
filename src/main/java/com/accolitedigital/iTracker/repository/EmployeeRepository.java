package com.accolitedigital.iTracker.repository;

import com.accolitedigital.iTracker.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByEmail(String employeeName);
}

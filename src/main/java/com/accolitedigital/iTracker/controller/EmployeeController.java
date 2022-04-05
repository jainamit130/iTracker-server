package com.accolitedigital.iTracker.controller;

import com.accolitedigital.iTracker.model.Employee;
import com.accolitedigital.iTracker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userView")
@CrossOrigin(origins = "http://ec2-15-206-211-127.ap-south-1.compute.amazonaws.com:8080")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //only used in postman for testing...is not used in UI
    @PostMapping("/add")
    public String add(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return "New employee is added";
    }

    //only used in postman for testing...is not used in UI
    @PostMapping("/addAll")
    public String addAll(@RequestBody List<Employee> employee){
        employeeService.saveAllEmployee(employee);
        return "New employees are added";
    }

    //only used in postman for testing...is not used in UI
    @GetMapping("/getAll")
    public List<Employee> list(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get")
    public Employee usersByName(@RequestParam String email) { return employeeService.getEmployeeByEmail(email); }

    @PutMapping("/update")
    public String update(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return "Employee "+employee.getId()+" updated!";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Integer id){
        employeeService.deleteEmployee(id);
        return "Employee with id "+id+" is deleted!";
    }

}
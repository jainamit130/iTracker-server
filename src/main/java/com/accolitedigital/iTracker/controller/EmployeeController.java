package com.accolitedigital.iTracker.controller;

import com.accolitedigital.iTracker.model.Employee;
import com.accolitedigital.iTracker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userView")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public String add(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return "New employee is added";
    }

    @PostMapping("/addAll")
    public String addAll(@RequestBody List<Employee> employee){
        employeeService.saveAllEmployee(employee);
        return "New employees are added";
    }

    @GetMapping("/getAll")
    public List<Employee> list(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public Employee individual(@PathVariable Integer id){
        return employeeService.getEmployee(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Integer id,@RequestBody Employee employee){
        employeeService.updateEmployee(id,employee);
        return "Employee "+id+" updated!";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
        return "Employee with id "+id+" is deleted!";
    }

}
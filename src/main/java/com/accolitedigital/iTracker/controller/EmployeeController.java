package com.accolitedigital.iTracker.controller;

import com.accolitedigital.iTracker.exception.UserNotFoundException;
import com.accolitedigital.iTracker.model.Employee;
import com.accolitedigital.iTracker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/userView")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public String add(@RequestBody @Valid Employee employee) {
        employeeService.saveEmployee(employee);
        return "New employee is added";
    }

    @PostMapping("/addAll")
    public String addAll(@RequestBody @Valid List<Employee> employee){
        employeeService.saveAllEmployee(employee);
        return "New employees are added";
    }

    @GetMapping("/getAll")
    public List<Employee> list(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get")
    public Employee usersByName(@RequestParam String email) throws UserNotFoundException { return employeeService.getEmployeeByEmail(email); }

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
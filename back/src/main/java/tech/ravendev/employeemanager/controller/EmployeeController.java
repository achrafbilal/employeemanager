package tech.ravendev.employeemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ravendev.employeemanager.model.Employee;
import tech.ravendev.employeemanager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> index() {
        return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeService.findEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> store(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> store(@PathVariable("id") Long id){
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

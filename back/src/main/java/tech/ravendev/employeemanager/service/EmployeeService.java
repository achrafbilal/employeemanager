package tech.ravendev.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ravendev.employeemanager.exception.UserNotFoundException;
import tech.ravendev.employeemanager.model.Employee;
import tech.ravendev.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException(String.format("Employee with id {0} was not found.",id)));
    }
    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }


}

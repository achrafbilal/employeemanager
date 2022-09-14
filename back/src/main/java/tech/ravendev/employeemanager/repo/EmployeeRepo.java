package tech.ravendev.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ravendev.employeemanager.model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    public void deleteEmployeeById(Long id);
    Optional<Employee> findEmployeeById(Long id);
}

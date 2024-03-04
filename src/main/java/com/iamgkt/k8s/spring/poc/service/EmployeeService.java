package com.iamgkt.k8s.spring.poc.service;

import com.iamgkt.k8s.spring.poc.model.Employee;
import com.iamgkt.k8s.spring.poc.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    /**
     * Saves an employee.
     *
     * @param employee The employee to be saved.
     * @return The saved employee.
     */
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    /**
     * Retrieves an employee by ID.
     *
     * @param id The ID of the employee.
     * @return An Optional containing the employee, or empty if not found.
     */
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    /**
     * Retrieves all employees.
     *
     * @return A list of all employees.
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Updates an existing employee.
     *
     * @param id          The ID of the employee to be updated.
     * @param newEmployee The updated employee data.
     * @return The updated employee.
     * @throws RuntimeException if the employee with the given ID is not found.
     */
    public Employee updateEmployee(Long id, Employee newEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(newEmployee.getName());
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    /**
     * Deletes an employee by ID.
     *
     * @param id The ID of the employee to be deleted.
     */
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

package com.iamgkt.k8s.spring.poc.loader;

import com.iamgkt.k8s.spring.poc.model.Employee;
import com.iamgkt.k8s.spring.poc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeService employeeService;

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Autowired
    public DataLoader(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Populate the database with mock Employee data
        Employee employee1 = new Employee();
        employee1.setName("John Doe");
        employeeService.saveEmployee(employee1);

        Employee employee2 = new Employee();
        employee2.setName("Jane Smith");
        employeeService.saveEmployee(employee2);

        // Add more mock Employees
        Employee employee3 = new Employee();
        employee3.setName("Alice Johnson");
        employeeService.saveEmployee(employee3);

        Employee employee4 = new Employee();
        employee4.setName("Bob Brown");
        employeeService.saveEmployee(employee4);

        // Add as many Employees as needed
    }
}

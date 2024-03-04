package com.iamgkt.k8s.spring.poc.repository;

import com.iamgkt.k8s.spring.poc.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

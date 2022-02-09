package com.EmployeeManagementApplication.demo.data.repository;

import com.EmployeeManagementApplication.demo.data.mdoel.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

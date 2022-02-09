package com.EmployeeManagementApplication.demo.service;

import com.EmployeeManagementApplication.demo.data.dto.EmployeeDto;
import com.EmployeeManagementApplication.demo.data.mdoel.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmplyee(EmployeeDto employeeDto);
    List<Employee> findAllEmployee();
    Employee  updateEmploye(Long employeeId);
    void deleteEmployee();
    Employee getEmployeeById(Long employeeId);

}

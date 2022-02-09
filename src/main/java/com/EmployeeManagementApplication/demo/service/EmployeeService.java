package com.EmployeeManagementApplication.demo.service;

import com.EmployeeManagementApplication.demo.data.dto.EmployeeDto;
import com.EmployeeManagementApplication.demo.data.mdoel.Employee;
import com.EmployeeManagementApplication.demo.web.exceptions.EmployeeException;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmplyee(EmployeeDto employeeDto);
    List<Employee> findAllEmployee();
    Employee  updateEmploye(Long employeeId, JsonPatch employeePatch) throws EmployeeException;
    void deleteEmployee(Long employeeId);
    Employee getEmployeeById(Long employeeId);

}

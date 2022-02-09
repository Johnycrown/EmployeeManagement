package com.EmployeeManagementApplication.demo.service;

import com.EmployeeManagementApplication.demo.data.dto.EmployeeDto;
import com.EmployeeManagementApplication.demo.data.mdoel.Employee;
import com.EmployeeManagementApplication.demo.data.repository.EmployeeRepository;
import com.EmployeeManagementApplication.demo.web.exceptions.EmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee addEmplyee(EmployeeDto employeeDto) {
        if(employeeDto == null){
            throw  new IllegalArgumentException("the employeeDto can not be null");
        }
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setLastName(employeeDto.getLastName());
        employee.setAddress(employeeDto.getAddress());

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }
    private Employee saveorUpdateEmployee(Employee employee) throws EmployeeException {
        if(employee == null){
            throw new EmployeeException("the employee can not be null");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmploye(Long employeeId) throws EmployeeException {
       Optional<Employee> employeeQuery = employeeRepository.findById(employeeId);
       if(employeeQuery.isEmpty()){
           throw  new EmployeeException("the employee with "+ employeeId + "does not exist");
       }
        return null;
    }

    @Override
    public void deleteEmployee() {

    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return null;
    }
}

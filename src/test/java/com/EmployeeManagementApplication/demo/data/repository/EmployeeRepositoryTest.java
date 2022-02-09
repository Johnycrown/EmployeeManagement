package com.EmployeeManagementApplication.demo.data.repository;

import com.EmployeeManagementApplication.demo.data.mdoel.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.List;

//import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Sql(scripts = {"/Db/insert.sql"})
class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    @DisplayName("test that employee can be saved")
    void saveEmployee(){
        Employee employee = new Employee();
        employee.setAddress("adekule ajasin");
        employee.setFirstName("adewale");
        employee.setLastName("Boluwatife");
        employee.setPhoneNumber("0812344223");
       // employee.setDateCreated();
        assertThat(employee.getEmployeeId()).isNull();
        employeeRepository.save(employee);
        assertThat(employee.getEmployeeId()).isNotNull();
        assertThat(employee.getFirstName()).isEqualTo("adewale");
        assertThat(employee.getLastName()).isEqualTo("Boluwatife");


    }
    @Test
    @DisplayName("Employee data can be findById")
    void findEmployeeById(){
        Employee employee = new Employee();
        employee.setAddress("adekule ajasin");
        employee.setFirstName("adewale");
        employee.setLastName("Boluwatife");
        employee.setPhoneNumber("0812344223");
        employeeRepository.save(employee);
        Employee employee2 = new Employee();

        employee2.setAddress("DEJIOLA ajasin");
        employee2.setFirstName("JUDE");
        employee2.setLastName("TIFE");
        employee2.setPhoneNumber("08134253635");
        employeeRepository.save(employee2);
        Employee queryEmployee = employeeRepository.findById(employee.getEmployeeId()).orElse(null);
        assertThat(queryEmployee.getFirstName()).isEqualTo("adewale");
        Employee queryEmployee2 = employeeRepository.findById(employee2.getEmployeeId()).orElse(null);
        assertThat(queryEmployee2.getFirstName()).isEqualTo("JUDE");

    }
    @Test
    @DisplayName("find all employee in the database")
    void findAllEmployeeIntheDatabase(){
        Employee employee = new Employee();
        employee.setAddress("adekule ajasin");
        employee.setFirstName("adewale");
        employee.setLastName("Boluwatife");
        employee.setPhoneNumber("0812344223");
        employeeRepository.save(employee);
        Employee employee2 = new Employee();

        employee2.setAddress("DEJIOLA ajasin");
        employee2.setFirstName("JUDE");
        employee2.setLastName("TIFE");
        employee2.setPhoneNumber("08134253635");
        employeeRepository.save(employee2);
        List<Employee> employees = employeeRepository.findAll();
        assertThat(employees).isNotNull();
        assertThat(employeeRepository.findAll().size()).isEqualTo(2);

    }
    @Test
    @DisplayName("delete  employee by Id in the database")
    void deleteEmployeeId(){


    }

}
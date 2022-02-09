package com.EmployeeManagementApplication.demo.service;

import com.EmployeeManagementApplication.demo.data.dto.EmployeeDto;
import com.EmployeeManagementApplication.demo.data.mdoel.Employee;
import com.EmployeeManagementApplication.demo.data.repository.EmployeeRepository;
import com.EmployeeManagementApplication.demo.web.exceptions.EmployeeException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
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
    public Employee updateEmploye(Long employeeId, JsonPatch employeePatch) throws EmployeeException {
       Optional<Employee> employeeQuery = employeeRepository.findById(employeeId);
       if(employeeQuery.isEmpty()){
           throw  new EmployeeException("the employee with "+ employeeId + "does not exist");
       }
       Employee targetEmployee = employeeQuery.get();
       try{
           targetEmployee = applyPatchToEmployee(employeePatch, targetEmployee);
          return saveorUpdateEmployee(targetEmployee);

       } catch (JsonPatchException | JsonProcessingException | EmployeeException e) {

          throw  new EmployeeException("update failed");
       }


    }
    private  Employee applyPatchToEmployee(JsonPatch employeePatch, Employee targetEmployee) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = employeePatch
                          .apply(objectMapper.convertValue(targetEmployee, JsonNode.class));
        return objectMapper.treeToValue(patched, Employee.class);

    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if(employee == null){
            throw new IllegalArgumentException("the product can not be null");
        }

        employeeRepository.deleteById(employee.getEmployeeId());


    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isEmpty()){
            throw new IllegalArgumentException("the  can not be nu");
        }
        Employee targetEmployee = employee.get();
        return targetEmployee;



    }
}

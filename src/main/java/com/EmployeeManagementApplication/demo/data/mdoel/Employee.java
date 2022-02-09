package com.EmployeeManagementApplication.demo.data.mdoel;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;
//import org.springframework.data.annotation.Id;

 @Data
 @Entity
 public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long EmployeeId;
  private String firstName;
  private String lastName;
  private String Address;
  private String phoneNumber;
  @CreationTimestamp
  private LocalDateTime dateCreated;


 }

package com.java.employeeManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.employeeManagement.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

 @Query(value = "SELECT employee_no,employee_name,joining_date,department,salary FROM employee WHERE employee_name = employee_name;", nativeQuery = true)
 public Employee findEmployeeByName(String employee_name);
	
}
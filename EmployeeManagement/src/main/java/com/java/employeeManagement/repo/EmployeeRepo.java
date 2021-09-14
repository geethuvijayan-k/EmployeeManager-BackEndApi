package com.java.employeeManagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.employeeManagement.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	public static final String FIND_EMPLOYEE_BY_NAME = "SELECT employee_no,employee_name,joining_date,department,salary FROM employee WHERE employee_name = employee_name";

	@Query(value = FIND_EMPLOYEE_BY_NAME, nativeQuery = true)
	public List<Employee> findEmployeeByName(String employee_name);
	
}

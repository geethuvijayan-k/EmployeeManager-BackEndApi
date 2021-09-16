package com.java.employeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.employeeManagement.model.Employee;
import com.java.employeeManagement.repo.EmployeeRepo;

@Service
public class EmployeeService {

	private final EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee updateEmployee(Long employee_no, Employee employee) {
		/*
		 * Optional<Employee> emp= employeeRepo.findById(employee_no);
		 * emp.setDepartment(employee.getDepartment());
		 * emp.setEmployee_name(employee.getEmployee_name());
		 * emp.setEmployee_no(employee.getEmployee_no());
		 * emp.setJoining_date(employee.getJoining_date());
		 * emp.setSalary(employee.getSalary()); return employeeRepo.save(emp);
		 */
		return employeeRepo.save(employee);
	}

	public void deleteEmployeeByNo(Long employee_no) {
		employeeRepo.deleteById(employee_no);
	}

	public List<Employee> findAllEmployees() {
		return employeeRepo.findAll();
	}

	public Optional<Employee> findEmpByNo(Long employee_no) {
		return Optional.of(employeeRepo.findById(employee_no).orElseThrow());
	}

	public Optional<List<Employee>> findEmployeeByEmployeeName(String employee_name) {
		return Optional.of(employeeRepo.findEmployeeByEmployeeName(employee_name));

	}

}

package com.java.employeeManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.employeeManagement.model.Employee;
import com.java.employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employeeList = employeeService.findAllEmployees();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}

	@GetMapping("/findByNo/{employee_no}")
	public ResponseEntity<Optional<Employee>> getEmployeeByNo(@PathVariable("employee_no") Long employee_no) {
		Optional<Employee> employee = employeeService.findEmpByNo(employee_no);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/findByName/{name}") public
	  ResponseEntity<Optional<List<Employee>>> getEmployeeByName(@PathVariable("name") String employee_name){
	     Optional<List<Employee>> employee=employeeService.findEmployeeByName(employee_name);
	  return new ResponseEntity<>(employee, HttpStatus.OK); }

	@PostMapping("/add")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		Employee employee = employeeService.addEmployee(emp);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}

	@PutMapping("/update/{employee_no}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long employee_no, @RequestBody Employee emp) {
		Employee employee = employeeService.updateEmployee(employee_no, emp);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{employee_no}")
	public ResponseEntity<?> deleteEmployeeByNo(@PathVariable Long employee_no) {
		employeeService.deleteEmployeeByNo(employee_no);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

package com.java.employeeManagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Employee {

	@Id
	private long employee_no;
	private String employee_name;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date joining_date;
	private String department;
	private double salary;

	public Employee(long employee_no, String employee_name, Date joining_date, String department, double salary) {
		this.employee_no = employee_no;
		this.employee_name = employee_name;
		this.joining_date = joining_date;
		this.department = department;
		this.salary = salary;
	}

	public Employee() {

	}

	public long getEmployee_no() {
		return employee_no;
	}

	public void setEmployee_no(long employee_no) {
		this.employee_no = employee_no;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public Date getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employee_no=" + employee_no + ", employee_name=" + employee_name + ", joining_date="
				+ joining_date + ", department=" + department + ", salary=" + salary + "]";
	}

}

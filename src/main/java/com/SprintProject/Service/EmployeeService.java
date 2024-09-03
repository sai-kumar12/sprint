package com.SprintProject.Service;

import java.util.List;
import java.util.Optional;

import com.SprintProject.entity.Employee;
import com.SprintProject.entity.Office;

import java.util.List;

import com.SprintProject.entity.Employee;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeByNumber(int employeeNumber);

    List<Employee> findByOfficeCode(String officeCode);

    List<Employee> getEmployeesByCity(String city);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(int employeeNumber, Employee employeeDetails);

    //Employee updateEmployeeByNumber(int oldEmployeeNumber, int newEmployeeNumber);

    Employee getByEmployeeNumber(int employeeNumber, String role);

    void deleteEmployee(int employeeNumber);

   // Employee mapEmployeeToOffice(int employeeNumber, String officeCode);

	Employee updateEmployeeReportsTo(int oldEmployeeNumber, int newEmployeeNumber);

	void getOfficeDetails(int employeeNumber, String officeCode);
}

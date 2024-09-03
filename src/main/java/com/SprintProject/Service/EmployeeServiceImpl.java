package com.SprintProject.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SprintProject.Exception.CustomerAlreadyExistsException;
import com.SprintProject.Exception.CustomerNotFoundByCityException;
import com.SprintProject.Exception.EmployeeNotFoundException;
import com.SprintProject.Exception.OfficeNotFoundException;
import com.SprintProject.Repository.EmployeeRepository;
import com.SprintProject.Repository.OfficeRepsoitory;
import com.SprintProject.entity.Employee;
import com.SprintProject.entity.Office;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SprintProject.Repository.EmployeeRepository;

import com.SprintProject.entity.Employee;
import com.SprintProject.entity.Office;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private OfficeRepsoitory officeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByNumber(int employeeNumber) {
    	Optional<Employee> emp=employeeRepository.findById(employeeNumber);
        if(emp==null) {
        	throw new EmployeeNotFoundException("Employee not found By Id");
        }
        return emp.get();
    }

    @Override
    public List<Employee> findByOfficeCode(String officeCode) {
        List<Employee> emp=employeeRepository.findByOfficeCode(officeCode);
        if(emp.isEmpty()) {
        	throw new OfficeNotFoundException("Office Not found By Code");
        }
        return emp;
    }

    @Override
    public List<Employee> getEmployeesByCity(String city) {
        List<Employee> emp= employeeRepository.findByCity(city);
        if(emp.isEmpty()) {
        	throw new CustomerNotFoundByCityException("Customer not Found By City");
        }
        return emp;
    }

    @Override
    public Employee addEmployee(Employee employee) 
    {
    	int id=employee.getEmployeeNumber();
    	if(employeeRepository.existsById(id)){
    		throw new CustomerAlreadyExistsException("Customer id is already present");
    	}
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(int employeeNumber, Employee employeeDetails) {
        Employee existingEmployee = getEmployeeByNumber(employeeNumber);
        existingEmployee.setFirstName(employeeDetails.getFirstName());
        existingEmployee.setLastName(employeeDetails.getLastName());
        existingEmployee.setEmail(employeeDetails.getEmail());
        existingEmployee.setJobTitle(employeeDetails.getJobTitle());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public Employee getByEmployeeNumber(int employeeNumber, String role) {
        Employee employee = employeeRepository.findById(employeeNumber).orElse(null);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with number " + employeeNumber + " not found.");
        }
        employee.setRole(role);
        return employeeRepository.save(employee);
    }



   



    @Override
    public void deleteEmployee(int employeeNumber) {
        Employee employee = getEmployeeByNumber(employeeNumber);
        employeeRepository.delete(employee);
    }

    
//    public void getOfficeDetails(int employeeNumber, String officeCode) {
//        // Fetch the employee
//        Employee employee = getEmployeeByNumber(employeeNumber);
//        if (employee == null) {
//            throw new EmployeeNotFoundException("Employee with number " + employeeNumber + " not found.");
//        }
//        
//        // Fetch the office
//        Office office = officeRepository.findByOfficeCode(officeCode).getOffice();
//        if (office == null) {
//            throw new OfficeNotFoundException("Office with code " + officeCode + " not found.");
//        }
//        
//        // Set the office for the employee
//        employee.setOffice(office);
//        
//        // Save the updated employee to the repository
//        employeeRepository.save(employee);
//        
//    }

	@Override
	public Employee updateEmployeeReportsTo(int oldEmployeeNumber, int newEmployeeNumber) {
		Employee oldEmployee = employeeRepository.findById(oldEmployeeNumber)
	            .orElseThrow(() -> new EmployeeNotFoundException("Employee with number " + oldEmployeeNumber + " not found."));
	        
	        Employee newManager = employeeRepository.findById(newEmployeeNumber)
	            .orElseThrow(() -> new EmployeeNotFoundException("New manager with number " + newEmployeeNumber + " not found."));
	        
	        oldEmployee.setReportsTo(newManager);
	        return employeeRepository.save(oldEmployee);
	}

	@Override
	public void getOfficeDetails(int employeeNumber, String officeCode) {
		Employee employee = getEmployeeByNumber(employeeNumber);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with number " + employeeNumber + " not found.");
        }
        
        // Fetch the office
        Office office=officeRepository.findByOfficeCode(officeCode);
        if (office == null) {
            throw new OfficeNotFoundException("Office with code " + officeCode + " not found.");
        }
        
        // Set the office for the employee
        employee.setOffice(office);
        
        // Save the updated employee to the repository
        employeeRepository.save(employee);
	}

	

	

	

}

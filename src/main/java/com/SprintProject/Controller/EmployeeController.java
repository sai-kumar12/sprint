package com.SprintProject.Controller;

import com.SprintProject.Exception.EmployeeNotFoundException;
import com.SprintProject.Exception.SuccessResponse;
import com.SprintProject.Service.EmployeeService;
import com.SprintProject.entity.Employee;
import com.SprintProject.entity.Office;

import org.hibernate.annotations.processing.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;




import com.SprintProject.Exception.SuccessResponse;
import com.SprintProject.Service.EmployeeService;
import com.SprintProject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{employee_no}")
    public ResponseEntity<Employee> getEmployeeByNumber(@PathVariable("employee_no") int employeeNumber) {
        try {
            Employee employee = employeeService.getEmployeeByNumber(employeeNumber);
            return ResponseEntity.ok(employee);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/office/{office_code}")
    public ResponseEntity<List<Employee>> getEmployeesByOffice(@PathVariable("office_code") String officeCode) {
        List<Employee> employees = employeeService.findByOfficeCode(officeCode);
        if (employees==null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Employee>> getEmployeesByCity(@PathVariable("city") String city) {
        List<Employee> employees = employeeService.getEmployeesByCity(city);
        if (employees.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/add")
    public ResponseEntity<SuccessResponse> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        SuccessResponse response = new SuccessResponse(LocalDate.now(), "Employee details added successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{employee_number}")
    public ResponseEntity<SuccessResponse> updateEmployee(@PathVariable("employee_number") int employeeNumber, @RequestBody Employee employeeDetails) {
        employeeService.updateEmployee(employeeNumber, employeeDetails);
        SuccessResponse response = new SuccessResponse(LocalDate.now(), "Employee details updated successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    
    @PutMapping("/{oldEmployeeNumber}/reports_to/{newEmployeeNumber}")
    public ResponseEntity<SuccessResponse> updateReportsTo(@PathVariable("oldEmployeeNumber") int oldEmployeeNumber, @PathVariable("newEmployeeNumber") int newEmployeeNumber) {
            employeeService.updateEmployeeReportsTo(oldEmployeeNumber, newEmployeeNumber);
            SuccessResponse response = new SuccessResponse(LocalDate.now(), "Employee reporting structure updated successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        
    }

    @PutMapping("/{employeeNumber}/role/{role}")
    public ResponseEntity<SuccessResponse> updateEmployeeRole(@PathVariable("employeeNumber") int employeeNumber, @PathVariable("role") String role) {
            employeeService.getByEmployeeNumber(employeeNumber, role);
            SuccessResponse response = new SuccessResponse(LocalDate.now(), "Employee role updated successfully");
            return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //this
    @PutMapping("/{employee_number}/map_to_office/{office_code}")
    public ResponseEntity<SuccessResponse> mapEmployeeToOffice(@PathVariable("employee_number") int employeeNumber, @PathVariable("office_code") String officeCode) {
        employeeService.getOfficeDetails(employeeNumber, officeCode);
        SuccessResponse response = new SuccessResponse(LocalDate.now(), "Employee office details updated successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/delete/{employee_number}")
    public ResponseEntity<SuccessResponse> deleteEmployee(@PathVariable("employee_number") int employeeNumber) {
        employeeService.deleteEmployee(employeeNumber);
        SuccessResponse response = new SuccessResponse(LocalDate.now(), "Employee details deleted successfully");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}

//@RestController
//@RequestMapping("/api/v1/employee")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//    
//
//    @GetMapping("/all")
//    public ResponseEntity<List<Employee>> getAllEmployees() {
//        List<Employee> employees = employeeService.getAllEmployees();
//        return ResponseEntity.ok(employees);
//    }
//
//    @GetMapping("/{employee_no}")
//    public Employee getEmployeeByNumber(@PathVariable("employee_no") int employeeNumber) {
//        Employee employee = employeeService.getEmployeeByNumber(employeeNumber);
//        return employee;
//    }
//    
//    @GetMapping("/office/{office_code}")
//    public ResponseEntity<Employee> getEmployeesByOffice(@PathVariable("office_code") String officeCode) {
//        Employee employees = employeeService.findByOfficeCode(officeCode);
//        if (employees==null) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(employees);
//    }
//
//    
//    @GetMapping("/city/{city}")
//    public ResponseEntity<List<Employee>> getEmployeesByCity(@PathVariable("city") String city) {
//        List<Employee> employees = employeeService.getEmployeesByCity(city);
//        if (employees.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(employees);
//    }
//    
//    
//    @PostMapping("/add")
//    public ResponseEntity<SuccessResponse> addEmployee(@RequestBody Employee employee) {
//        Employee savedEmployee = employeeService.addEmployee(employee);
//        SuccessResponse sr=new SuccessResponse();
//        sr.setMessage("Employee details added successfully");
//        sr.setTimestamp(LocalDate.now());
//        return ResponseEntity.ok(sr);
//    }
//
//    @PutMapping("/update/{employee_number}")
//    public ResponseEntity<SuccessResponse> updateEmployee(@PathVariable("employee_number") int employeeNumber, @RequestBody Employee employeeDetails) {
//        Employee updatedEmployee = employeeService.updateEmployee(employeeNumber, employeeDetails);
//        SuccessResponse sr=new SuccessResponse();
//        sr.setMessage("Employee details updated successfully");
//        sr.setTimestamp(LocalDate.now());
//        return ResponseEntity.ok(sr);
//    }
//    @PutMapping("/{oldEmployeeNumber}/reports_to/{newEmployeeNumber}")
//    public ResponseEntity<Employee> updateReportsTo(@PathVariable("oldEmployeeNumber") int oldEmployeeNumber, @PathVariable("newEmployeeNumber") int newEmployeeNumber) {
//        try {
//            Employee updatedEmployee = employeeService.updateEmployeeReportsTo(oldEmployeeNumber, newEmployeeNumber);
//            return ResponseEntity.ok(updatedEmployee);
//        } catch (EmployeeNotFoundException e) {
//            return ResponseEntity.notFound().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//    }
//
//
////    @GetMapping("/role/{role}")
////    public ResponseEntity<List<Employee>> getEmployeesByRole(@PathVariable("role") String role) {
////        List<Employee> employees = employeeService.getEmployeesByRole(role);
////        return ResponseEntity.ok(employees);
////    }
//    @PutMapping("/{employeeNumber}/role/{role}")
//    public ResponseEntity<Employee> updateEmployeeRole(@PathVariable("employeeNumber") int employeeNumber, @PathVariable("role") String role) {
//        try {
//            Employee updatedEmployee = employeeService.getByEmployeeNumber(employeeNumber, role);
//            return ResponseEntity.ok(updatedEmployee);
//        } catch (NoSuchElementException e) {
//            return ResponseEntity.notFound().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//    }
//
//  //need to check
//    @PutMapping("/{employee_number}/map_to_office/{office_code}")
//    public ResponseEntity<Employee> mapEmployeeToOffice(@PathVariable("employee_number") int employeeNumber, @PathVariable("office_code") String officeCode) {
//        Employee updatedEmployee = employeeService.mapEmployeeToOffice(employeeNumber, officeCode);
//        return ResponseEntity.ok(updatedEmployee);
//    }
//
//    @DeleteMapping("/delete/{employee_number}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable("employee_number") int employeeNumber) {
//        employeeService.deleteEmployee(employeeNumber);
//        return ResponseEntity.noContent().build();
//    }
//
//
//
//
//}
//
////{
////    "employeeNumber": 2003,
////    "email": "dmurphy@classicmodelcars.com",
////    "role": "soft",
////    "lastName": "Murphy",
////    "firstName": "Diane",
////    "extension": "x5800",
////    "jobTitle": "President",
////    "reportsTo": {
////      "employeeNumber": 1143
////    },
////    "office": {
////        "officeCode": "1",
////        "city": "San Francisco",
////        "phone": "+1 650 219 4782",
////        "addressLine1": "100 Market Street",
////        "addressLine2": "Suite 300",
////        "state": "CA",
////        "country": "USA",
////        "postalCode": "94080",
////        "territory": "NA"
////    }
////}
//

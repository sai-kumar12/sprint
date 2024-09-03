package com.SprintProject.Controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SprintProject.Service.CustomerService;
import com.SprintProject.entity.Customer;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/contact_lastname/{contact_lastname}")
    public ResponseEntity<List<Customer>> getCustomersByContactLastName(@PathVariable("contact_lastname") String contactLastName) {
        List<Customer> customers = customerService.getCustomersByContactLastName(contactLastName);
        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }
    
    @GetMapping("/credit_limit/{credit_limit}")
    public ResponseEntity<List<Customer>> getCustomersByCreditLimit(@PathVariable("credit_limit") BigDecimal creditLimit) {
        List<Customer> customers = customerService.getCustomersByCreditLimit(creditLimit);
        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/postal_code/{postal_code}")
    public ResponseEntity<List<Customer>> getCustomersByPostalCode(@PathVariable("postal_code") String postalCode) {
        List<Customer> customers = customerService.getCustomersByPostalCode(postalCode);
        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/credit_range/{min_credit}/{max_credit}")
    public ResponseEntity<List<Customer>> getCustomersByCreditRange(
            @PathVariable("min_credit") BigDecimal minCredit, 
            @PathVariable("max_credit") BigDecimal maxCredit) {
        List<Customer> customers = customerService.getCustomersByCreditRange(minCredit, maxCredit);
        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }
    
    
}


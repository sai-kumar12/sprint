package com.SprintProject.Service;

import java.math.BigDecimal;
import java.util.List;

import com.SprintProject.entity.Customer;

public interface CustomerService {

	 List<Customer> getCustomersByContactLastName(String contactLastName);
	 
	 List<Customer> getCustomersByCreditLimit(BigDecimal creditLimit);

	 List<Customer> getCustomersByPostalCode(String postalCode);

	 List<Customer> getCustomersByCreditRange(BigDecimal minCredit, BigDecimal maxCredit);
}

package com.SprintProject.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SprintProject.Repository.CustomerRepository;
import com.SprintProject.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
    private CustomerRepository customerRepository;

	@Override
    public List<Customer> getCustomersByContactLastName(String contactLastName) {
        return customerRepository.findByContactLastName(contactLastName);
    }
	
	@Override
    public List<Customer> getCustomersByCreditLimit(BigDecimal creditLimit) {
        return customerRepository.findByCreditLimit(creditLimit);
    }

    @Override
    public List<Customer> getCustomersByPostalCode(String postalCode) {
        return customerRepository.findByPostalCode(postalCode);
    }

    @Override
    public List<Customer> getCustomersByCreditRange(BigDecimal minCredit, BigDecimal maxCredit) {
        return customerRepository.findByCreditLimitRange(minCredit, maxCredit);
    }
}

package com.SprintProject.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SprintProject.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	@Query("select c from Customer c where c.contactLastName = :contactLastName")
	List<Customer> findByContactLastName(@Param("contactLastName") String contactLastName);
	
	@Query("select c from Customer c where c.creditLimit = :creditLimit")
	List<Customer> findByCreditLimit(BigDecimal creditLimit);

	
    @Query("select c from Customer c where c.postalcode= :postalcode")
    List<Customer> findByPostalCode(String postalcode);

  
    @Query("select c from  Customer c where c.creditLimit between :minCredit AND :maxCredit")
    List<Customer> findByCreditLimitRange(@Param("minCredit") BigDecimal minCredit, @Param("maxCredit") BigDecimal maxCredit);
}

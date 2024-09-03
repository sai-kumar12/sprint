package com.SprintProject.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SprintProject.entity.Customer;
import com.SprintProject.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
   // Optional<Employee> findById(Integer employeeNumber);

    @Query("select e from Employee e where e.office.officeCode = :officeCode")
    List<Employee> findByOfficeCode(@Param("officeCode") String officeCode);
    
    @Query("select e from  Employee e where e.office.city = :city")
    List<Employee> findByCity(@Param("city") String city);
    
    @Query("select e from Employee e where e.employeeNumber= :employeeNumber")
    Employee findByemployeeNumber(@Param("employeeNumber") int employeeNumber);

	
    
    
    
    //@Query("select p Products p where p.poductCode =:productCode in (select sum(o.quantityOrdered) from OrderDetails o")
    
    
    
}


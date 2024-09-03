package com.SprintProject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SprintProject.entity.Employee;
import com.SprintProject.entity.Office;

@Repository
public interface OfficeRepsoitory extends JpaRepository<Office,String>{
	@Query("select o from Office o where o.officeCode=:officeCode")
	Office findByOfficeCode(@Param("officeCode") String officeCode);

}

package com.SprintProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SprintProject.entity.Payments;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments,String>{

}

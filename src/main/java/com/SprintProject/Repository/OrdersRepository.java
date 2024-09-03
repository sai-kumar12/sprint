package com.SprintProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SprintProject.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer>{

}

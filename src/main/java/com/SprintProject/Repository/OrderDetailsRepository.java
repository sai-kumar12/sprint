package com.SprintProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SprintProject.entity.OrderDetailId;
import com.SprintProject.entity.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,OrderDetailId>{

}

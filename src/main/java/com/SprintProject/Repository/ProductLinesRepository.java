package com.SprintProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SprintProject.entity.ProductLines;

@Repository
public interface ProductLinesRepository extends JpaRepository<ProductLines,String>{

}

package com.SprintProject.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailId implements Serializable {
 
	
    private int orderNumber;
    
    private String productCode;
 
    // Getters, Setters, equals(), and hashCode() methods
}

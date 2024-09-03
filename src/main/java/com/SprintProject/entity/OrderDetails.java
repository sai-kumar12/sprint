package com.SprintProject.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OrderDetails")
public class OrderDetails {

    @EmbeddedId
    private OrderDetailId id;

    @JsonBackReference
    @ManyToOne
    @MapsId("orderNumber") // Maps orderNumber in OrderDetailId
    @JoinColumn(name = "orderNumber", nullable = false)
    private Orders order;

    @JsonBackReference
    @ManyToOne
    @MapsId("productCode") // Maps productCode in OrderDetailId
    @JoinColumn(name = "productCode", nullable = false, columnDefinition = "VARCHAR(15)")
    private Product product;

    @Column(nullable = false)
    private int quantityOrdered;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal priceEach;

    @Column(nullable = false)
    private short orderLineNumber;

    // Getters and Setters
}


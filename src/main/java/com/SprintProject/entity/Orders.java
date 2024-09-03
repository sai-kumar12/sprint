package com.SprintProject.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    private int orderNumber;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date requiredDate;
    @Column
    @Temporal(TemporalType.DATE)
    private Date shippedDate;
    @Column(length = 15, nullable = false)
    private String status;
    @Column(columnDefinition="TEXT")
    private String comments;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customerNumber",nullable = false)
    private Customer customers;
    @JsonBackReference
    @OneToMany(mappedBy="order")
    private List<OrderDetails> orderDetails;
}

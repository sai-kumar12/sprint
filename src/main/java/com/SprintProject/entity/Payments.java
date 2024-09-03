package com.SprintProject.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="payments")
@IdClass(PaymentId.class)
public class Payments {

    @Id
    @Column(name = "checkNumber", length = 50)
    private String checkNumber;

    @Id
    @Column(name = "customerNumber", insertable = false, updatable = false)
    private Integer customerNumber;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customerNumber", nullable = false)
    private Customer customers;

    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date paymentDate;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;
}

package com.SprintProject.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
@Entity
@Table(name="products")
public class Product {
	   @Id
	   @Column(length = 15, nullable = false)
	   private String productCode;
	   
	   @Column(name = "productName", length = 70, nullable = false)
	   private String productName;
	   
	   @ManyToOne
	   @JsonBackReference
	   @JoinColumn(name="productLine",nullable = false)
	   private ProductLines productLine;
	   @Column(name = "productScale", length = 10, nullable = false)
	   private String productScale;
	   @Column(name = "productVendor", length = 50, nullable = false)
	   private String productVendor;
	   @Column(name = "productDescription", columnDefinition = "TEXT", nullable = false)
	   private String productDescription;
	   @Column(name = "quantityInStock", nullable = false)
	   private short quantityInStock;
	   @Column(name = "buyPrice", precision = 10, scale = 2, nullable = false)
	   private BigDecimal buyPrice;
	   @Column(name = "MSRP", precision = 10, scale = 2, nullable = false)
	   private BigDecimal msrp;
	   @OneToMany(mappedBy="product")
	   
	   private List<OrderDetails> orderDetails;
	   
}
 
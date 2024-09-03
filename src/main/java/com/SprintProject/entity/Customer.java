package com.SprintProject.entity;
 
import java.math.BigDecimal;
import java.util.List;
 
 //This is ram file
//This is saikumar
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity@Table(name="customers")
public class Customer {
	@Id
	private int customerNumber;
	@Column(length = 50, nullable = false)
	private String customerName;
	@Column(length = 50, nullable = false)
	private String contactLastName;
	@Column(length = 50, nullable = false)
	private String contactFirstName;
	@Column(length = 50, nullable = false)
	private String phone;
	@Column(length = 50, nullable = false)
	private String addressLine1;
	@Column(length = 50)
	private String addressLine2;
	@Column(length = 50, nullable = false)
	private String city;
	@Column(length = 50)
	private String state;
	@Column(length = 15)
	private String postalcode;
	@Column(length = 50, nullable = false)
	private String country;
	@Column(precision = 10,scale=2)
	private  BigDecimal creditLimit;
	@ManyToOne
	@JoinColumn(name="salesRepEmployeeNumber",referencedColumnName = "employeeNumber")
	//@JsonBackReference("employee-customer")
	private Employee emp;
	@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
	//@JsonManagedReference("customer-payments")
	@JsonIgnore
	private List<Payments> payments;
	@OneToMany(mappedBy="customers",cascade= CascadeType.ALL)
	//@JsonManagedReference("customer-order")
	@JsonIgnore
	private List<Orders> orders;

	}

package com.SprintProject.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    private int employeeNumber;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String role;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 10, nullable = false)
    private String extension;

    @Column(length = 50, nullable = false)
    private String jobTitle;

    

    @ManyToOne
    @JoinColumn(name = "reportsTo")
    //@JsonBackReference
    private Employee reportsTo;
    @ManyToOne
    @JoinColumn(name = "officeCode")
    //@JsonBackReference
    private Office office;
    @OneToMany(mappedBy = "emp", cascade = CascadeType.ALL)
    //@JsonManagedReference("employee-customer")
    @JsonIgnore
    private List<Customer> customers;
    @OneToMany(mappedBy = "reportsTo", cascade = CascadeType.ALL)
    //@JsonManagedReference
   @JsonIgnore
    private List<Employee> reports;
}
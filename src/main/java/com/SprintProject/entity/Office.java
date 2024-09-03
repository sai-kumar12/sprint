package com.SprintProject.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "offices")
public class Office {

    @Id
    @Column(length = 10, nullable = false)
    private String officeCode;

    @Column(length = 50, nullable = false)
    private String city;

    @Column(length = 50, nullable = false)
    private String phone;

    @Column(length = 50, nullable = false)
    private String addressLine1;

    @Column(length = 50)
    private String addressLine2;

    @Column(length = 50)
    private String state;

    @Column(length = 50, nullable = false)
    private String country;

    @Column(length = 15, nullable = false)
    private String postalCode;

    @Column(length = 10, nullable = false)
    private String territory;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    //@JsonManagedReference
    @JsonIgnore
    private List<Employee> employees;
}

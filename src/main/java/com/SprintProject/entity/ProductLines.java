package com.SprintProject.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@ToString
@Table(name="productlines")
public class ProductLines {
	
	
   
    @Id
	@Column(length = 50)
	private String productLine;
	@Column(length=4000)
	 private String textDescription;
	@Column(columnDefinition="MEDIUMTEXT")
	 private String htmlDescription;
	@Column(columnDefinition="MEDIUMBLOB")
	 private byte[] image;
	 @OneToMany(mappedBy = "productLine",fetch = FetchType.LAZY)
	    @JsonManagedReference
		
		private List<Product> product;
 
	    
 
 
}
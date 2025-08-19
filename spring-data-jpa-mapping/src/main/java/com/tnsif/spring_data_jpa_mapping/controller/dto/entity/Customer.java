package com.tnsif.spring_data_jpa_mapping.controller.dto.entity;

import com.tnsif.spring_data_jpa_mapping.controller.dto.AllArgsConstructor;
import com.tnsif.spring_data_jpa_mapping.controller.dto.Data;
import com.tnsif.spring_data_jpa_mapping.controller.dto.NoArgsConstructor;
import com.tnsif.spring_data_jpa_mapping.controller.dto.ToString;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
	 @Id
	    @GeneratedValue
	    private int id;
	    private String name;
	    private String email;
	    private String gender;
	    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
	    @JoinColumn(name ="cp_fk",referencedColumnName = "id")
	    private List<Product> products;
}

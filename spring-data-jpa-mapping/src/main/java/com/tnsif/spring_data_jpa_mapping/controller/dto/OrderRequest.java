package com.tnsif.spring_data_jpa_mapping.controller.dto;

import com.javatechie.jpa.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {
	private Customer customer;

	public Object getCustomer() {
		// TODO Auto-generated method stub
		return null;
	}
}

package com.tnsif.customerservice.service;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsif.customerservice.entity.Customer;
import com.tnsif.customerservice.repository.CustomerRepository;

@Service
public class CustomerService {
	
		@Autowired
		private CustomerRepository repo;
		
		//to get all the records from table
		public List listAll(){
			return (List) repo.findAll();
			
			}
		
		//save the record
		public void save(Customer c) {
			repo.save(c);
		}
		
		
		//to call a specific record 
		public Customer get(Integer cid) { 
			return repo.findById(cid).get(); 
		}
		
		//delete particular record with id
		public void delete(Integer cid) {
			repo.deleteById(cid);
		}
		
		//for update
		public void update(Customer c) {
			repo.save(c);
		}

}

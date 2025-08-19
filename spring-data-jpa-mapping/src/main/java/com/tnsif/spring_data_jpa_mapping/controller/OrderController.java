package com.tnsif.spring_data_jpa_mapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.tnsif.spring_data_jpa_mapping.controller.dto.OrderRequest;
import com.tnsif.spring_data_jpa_mapping.controller.dto.OrderResponse;
import com.tnsif.spring_data_jpa_mapping.controller.dto.entity.Customer;
import com.tnsif.spring_data_jpa_mapping.controller.dto.entity.repository.CustomerRepository;
import com.tnsif.spring_data_jpa_mapping.controller.dto.entity.repository.ProductRepository;

@RestController
public class OrderController {
	 @Autowired
	 
	    private CustomerRepository customerRepository;
	    @Autowired
	    private ProductRepository productRepository;

	    @PostMapping("/placeOrder")
	    public Customer placeOrder(@RequestBody OrderRequest request){
	       return customerRepository.save(request.getCustomer());
	    }

	    @GetMapping("/findAllOrders")
	    public List<Customer> findAllOrders(){
	        return customerRepository.findAll();
	    }

	    @GetMapping("/getInfo")
	    public List<OrderResponse> getJoinInformation(){
	        return customerRepository.getJoinInformation();
	    }
}

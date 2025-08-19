package com.tnsif.spring_data_jpa_mapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}

package com.tnsif.spring_data_jpa_mapping.controller.dto.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.Customer;
import java.util.List;
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	@Query("SELECT new com.javatechie.jpa.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();
}

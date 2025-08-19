package com.tnsif.onetomanymapping.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsif.onetomanymapping.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}

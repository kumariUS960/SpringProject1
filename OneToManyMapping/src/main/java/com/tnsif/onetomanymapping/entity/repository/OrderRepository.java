package com.tnsif.onetomanymapping.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsif.onetomanymapping.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}

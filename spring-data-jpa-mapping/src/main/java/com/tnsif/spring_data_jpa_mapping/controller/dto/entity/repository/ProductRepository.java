package com.tnsif.spring_data_jpa_mapping.controller.dto.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsif.spring_data_jpa_mapping.controller.dto.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

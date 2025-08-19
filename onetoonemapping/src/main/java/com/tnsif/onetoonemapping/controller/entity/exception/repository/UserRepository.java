package com.tnsif.onetoonemapping.controller.entity.exception.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsif.onetoonemapping.controller.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

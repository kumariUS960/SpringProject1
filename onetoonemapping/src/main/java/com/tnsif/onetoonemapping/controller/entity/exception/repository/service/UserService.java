package com.tnsif.onetoonemapping.controller.entity.exception.repository.service;

import com.tnsif.onetoonemapping.controller.entity.User;
import com.tnsif.onetoonemapping.controller.entity.exception.UserNotFoundException;

import java.util.List;
public interface UserService {
	// Save a new User
    User saveUser(User user);

    // Get all Users
    List<User> getAllUsers();

    // Get User by ID, declare that it can throw UserNotFoundException
    User getUserById(Long id) throws UserNotFoundException;

    // Update a User by ID, declare that it can throw UserNotFoundException
    User updateUser(Long id, User updatedUser) throws UserNotFoundException;

    // Delete a User by ID, declare that it can throw UserNotFoundException
    boolean deleteUser(Long id) throws UserNotFoundException;

	User saveUser1(User user);

	User updateUser1(Long id, User updatedUser);
}

package com.tnsif.onetoonemapping.controller.entity.exception.repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsif.onetoonemapping.controller.entity.User;
import com.tnsif.onetoonemapping.controller.entity.exception.UserNotFoundException;
import com.tnsif.onetoonemapping.controller.entity.exception.repository.UserRepository;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	
    private UserRepository userRepository;

    // Save a new User
    @Override
    public User saveUser1(User user) {
        return userRepository.save(user);
    }

    // Get all Users
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get User by ID
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> 
            new UserNotFoundException("User with ID " + id + " not found")
        );
    }

    // Update a User by ID
    @Override
    public User updateUser1(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> 
            new UserNotFoundException("User with ID " + id + " not found")
        );

        // Update basic fields
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());

        // Other logic for updating profile...
        
        return userRepository.save(existingUser);
    }

    // Delete a User by ID
    @Override
    public boolean deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }
        userRepository.deleteById(id);
        return true;
    }

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(Long id, User updatedUser) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}

package com.tnsif.onetomanymapping.entity.exception.service;

import com.tnsif.onetomanymapping.entity.Customer;
import com.tnsif.onetomanymapping.entity.exception.CustomerNotFoundException;

import java.util.List;
public interface CustomerService {

    // Save a new customer
    Customer saveCustomer(Customer customer);

    // Get all customers
    List<Customer> getAllCustomers();

    // Get customer by ID
    Customer getCustomerById(Long id) throws CustomerNotFoundException; // Declare the exception

    // Update customer by ID
    Customer updateCustomer(Long id, Customer updatedCustomer) throws CustomerNotFoundException; // Declare the exception

    // Delete customer by ID
    boolean deleteCustomer(Long id) throws CustomerNotFoundException; // Declare the exception

	Customer saveCustomer1(Customer customer);

	Customer updateCustomer1(Long id, Customer updatedCustomer);
}

package com.tnsif.onetomanymapping.entity.exception.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.tnsif.onetomanymapping.entity.Customer;
import com.tnsif.onetomanymapping.entity.Order;
import com.tnsif.onetomanymapping.entity.exception.CustomerNotFoundException;
import com.tnsif.onetomanymapping.entity.repository.CustomerRepository;
import java.util.List;
public class CustomerServiceImpl implements CustomerService{
	 @Autowired
	    private CustomerRepository customerRepository;

	    // Save a new customer
	    @Override
	    public Customer saveCustomer1(Customer customer) {
	        // Ensure each order has a reference to the customer
	        if (customer.getOrders() != null) {
	            for (Order order : customer.getOrders()) {
	                order.setCustomer(customer);
	            }
	        }
	        return customerRepository.save(customer);
	    }

	    // Get all customers
	    @Override
	    public List<Customer> getAllCustomers() {
	        return customerRepository.findAll();
	    }

	    // Get a customer by ID
	    @Override
	    public Customer getCustomerById(Long id) {
	        return customerRepository.findById(id)
	                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + id)); // Pass custom message
	    }

	    // Update a customer by ID
	    @Override
	    public Customer updateCustomer1(Long id, Customer updatedCustomer) {
	        Customer existingCustomer = customerRepository.findById(id)
	                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + id)); // Pass custom message

	        // Update customer fields
	        existingCustomer.setName(updatedCustomer.getName());
	        existingCustomer.setCity(updatedCustomer.getCity());

	        // Ensure each order has a reference to the customer
	        if (updatedCustomer.getOrders() != null) {
	            for (Order order : updatedCustomer.getOrders()) {
	                order.setCustomer(existingCustomer);
	            }
	            existingCustomer.setOrders(updatedCustomer.getOrders()); // Set updated orders
	        }

	        return customerRepository.save(existingCustomer);
	    }

	    // Delete a customer by ID
	    @Override
	    public boolean deleteCustomer(Long id) {
	        if (!customerRepository.existsById(id)) {
	            throw new CustomerNotFoundException("Customer not found with ID: " + id); // Pass custom message
	        }
	        customerRepository.deleteById(id);
	        return true;
	    }

		@Override
		public Customer saveCustomer(Customer customer) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Customer updateCustomer(Long id, Customer updatedCustomer) throws CustomerNotFoundException {
			// TODO Auto-generated method stub
			return null;
		}
}

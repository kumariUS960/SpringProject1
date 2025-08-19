package com.tnsif.onetomanymapping.entity.repository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.tnsif.onetomanymapping.entity.Order;
import com.tnsif.onetomanymapping.entity.exception.OrderNotFoundException;

public class OrderServiceImpl {
	@Autowired
    private OrderRepository orderRepository;

    // Save a new order
    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    // Get all orders
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get order by ID
    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + id)); // Pass custom message
    }

    // Update order by ID
    @Override
    public Order updateOrder(Long id, Order updatedOrder) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with ID: " + id)); // Pass custom message

        // Update order fields
        existingOrder.setProduct(updatedOrder.getProduct());

        return orderRepository.save(existingOrder);
    }

    // Delete order by ID
    @Override
    public boolean deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException("Order not found with ID: " + id); // Pass custom message
        }
        orderRepository.deleteById(id);
        return true;
    }
}

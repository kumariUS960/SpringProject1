package com.tnsif.onetomanymapping.entity.exception;

public class OrderNotFoundException extends RuntimeException{
	 // Constructor accepting a custom message
    public OrderNotFoundException(String message) {
        super(message);
    }
}

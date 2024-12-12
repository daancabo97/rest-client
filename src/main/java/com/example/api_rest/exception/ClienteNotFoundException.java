package com.example.api_rest.exception;

public class ClienteNotFoundException extends RuntimeException {
	
    public ClienteNotFoundException(String message) {
        super(message);
    }
}

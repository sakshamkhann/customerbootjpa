package com.cap.apps.customerbootjpa.exceptions;

public class CustomerNotExistException extends RuntimeException{

    public CustomerNotExistException(String message) {
        super(message);
    }
}

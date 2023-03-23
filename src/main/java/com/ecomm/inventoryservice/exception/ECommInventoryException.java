package com.ecomm.inventoryservice.exception;

public class ECommInventoryException extends Exception{

    public ECommInventoryException(String message) {
        super(message);
    }

    public ECommInventoryException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.example.stocktransactionapp.exception.transaction;

public class NotEnoughFoundsException extends RuntimeException {
    public NotEnoughFoundsException(String message) {
        super(message);
    }
}

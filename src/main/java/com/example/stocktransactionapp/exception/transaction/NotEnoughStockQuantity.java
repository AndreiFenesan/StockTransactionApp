package com.example.stocktransactionapp.exception.transaction;

public class NotEnoughStockQuantity extends RuntimeException {
    public NotEnoughStockQuantity(String message) {
        super(message);
    }
}

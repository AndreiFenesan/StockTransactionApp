package com.example.stocktransactionapp.exception.stockinfo;

public class StockNotFoundException extends RuntimeException {
    public StockNotFoundException(String message) {
        super(message);
    }
}

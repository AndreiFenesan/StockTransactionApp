package com.example.stocktransactionapp.exception.stockinfo;

public class UnableToGetStockPriceException extends RuntimeException {
    public UnableToGetStockPriceException(String message) {
        super(message);
    }
}

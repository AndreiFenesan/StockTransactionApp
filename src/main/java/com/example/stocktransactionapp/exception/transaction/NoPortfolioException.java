package com.example.stocktransactionapp.exception.transaction;

public class NoPortfolioException extends RuntimeException{
    public NoPortfolioException(String message) {
        super(message);
    }
}

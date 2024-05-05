package com.example.stocktransactionapp.exception.security;

public class InvalidTokenType extends RuntimeException{
    public InvalidTokenType() {
    }

    public InvalidTokenType(String message) {
        super(message);
    }
}

package com.example.stocktransactionapp.dto.transaction;

import lombok.Data;

@Data
public class TransactionDto {
    private String symbol;
    private double stockQuantity;
}

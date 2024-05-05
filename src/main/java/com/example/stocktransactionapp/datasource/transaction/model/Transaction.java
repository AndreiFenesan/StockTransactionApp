package com.example.stocktransactionapp.datasource.transaction.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Transaction {

    private String id;
    private long timestamp;
    private String symbol;
    private double stockPrice;
    private double quantity;
    private TransactionType type;
}

package com.example.stocktransactionapp.datasource.transaction.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockPurchased {
    private String symbol;
    private double quantity;

    public void addQuantity(double purchasedQuantity) {
        quantity = quantity + purchasedQuantity;
    }

    public void subtractQuantity(double soldQuantity) {
        quantity = quantity - soldQuantity;
    }
}

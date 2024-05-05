package com.example.stocktransactionapp.datasource.transaction.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Optional;

@Document
@Builder
@Getter
@Setter
public class StockPortfolio {
    @Id
    private Integer userId;
    private double balance;
    private List<Transaction> transactions;
    private List<StockPurchased> stockedBought;

    public void addBuyTransaction(Transaction transaction) {
        transactions.add(transaction);
        var quantity = transaction.getQuantity();
        var symbol = transaction.getSymbol();
        stockedBought.stream()
                .filter(stock -> stock.getSymbol().equals(symbol)).findAny()
                .ifPresentOrElse(
                        stockBought -> stockBought.addQuantity(quantity),
                        () -> stockedBought.add(StockPurchased.builder()
                                .symbol(symbol)
                                .quantity(quantity)
                                .build()));

    }
    public void addSellTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Optional<StockPurchased> getStockPurchasedBySymbol(String symbol) {
        return stockedBought.stream()
                .filter(stockPurchased -> stockPurchased.getSymbol().equals(symbol))
                .findAny();
    }
}
package com.example.stocktransactionapp.datasource.transaction.repository;

import com.example.stocktransactionapp.datasource.transaction.model.StockPortfolio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPortfolioRepository extends MongoRepository<StockPortfolio, Integer> {
}
package com.example.stocktransactionapp.service.stockinfo;

import com.example.stocktransactionapp.config.stockinfo.StockInfoConfig;
import com.example.stocktransactionapp.exception.stockinfo.StockNotFoundException;
import com.example.stocktransactionapp.exception.stockinfo.UnableToGetStockPriceException;
import com.example.stocktransactionapp.model.stockinfo.Stock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockService {

    private final StockInfoConfig stockInfoConfig;

    public Stock getBySymbol(String symbol) {
        String stockName = stockInfoConfig.getSymbolToStockName().get(symbol);
        if (stockName == null) {
            throw new StockNotFoundException("Stock not found");
        }
        double price = getPrice(stockName);
        if (price == -1) {
            throw new UnableToGetStockPriceException("Unable to get stock price");
        }
        return Stock.builder()
                .symbol(symbol)
                .price(price)
                .dateTime(LocalDateTime.now())
                .build();
    }

    private double getPrice(String stockName) {
        try {
            var infoUrl = MessageFormat.format(stockInfoConfig.getHost(), stockName);
            var doc = Jsoup.connect(infoUrl).get();
            var elements = doc.selectXpath(stockInfoConfig.getXPath());
            var price = elements.get(0).text();
            return Double.parseDouble(price);
        } catch (Exception e) {
            log.error("Error in getting price for: {} due to: ", stockName, e);
        }
        return -1;
    }
}

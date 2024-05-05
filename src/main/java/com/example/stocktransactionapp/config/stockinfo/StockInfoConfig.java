package com.example.stocktransactionapp.config.stockinfo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "investing")
@Getter
@Setter
public class StockInfoConfig {

    private String host;
    private String xPath;
    Map<String, String> symbolToStockName;

}

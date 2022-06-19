package com.konstantinmb.trackyourportfolio.domain.mapper;

import com.konstantinmb.trackyourportfolio.domain.StockPositionRequest;
import com.konstantinmb.trackyourportfolio.entities.StockPosition;

public class StockPositionMapper {

    public static StockPosition toDtoStockPosition(StockPositionRequest domain){

        return StockPosition.builder()
                .stockName(domain.getStockName())
                .stockSymbol(domain.getStockSymbol())
                .stockAmount(domain.getStockAmount())
                .stockPrice(domain.getStockPrice())
                .build();
    }

    public static StockPositionRequest toDomainStockPosition(StockPosition dto){

        return StockPositionRequest.builder()
                .stockName(dto.getStockName())
                .stockSymbol(dto.getStockSymbol())
                .stockAmount(dto.getStockAmount())
                .stockPrice(dto.getStockPrice())
                .build();
    }
}

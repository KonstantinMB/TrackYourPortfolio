package com.konstantinmb.trackyourportfolio.service;


import com.konstantinmb.trackyourportfolio.entities.StockPosition;
import com.konstantinmb.trackyourportfolio.repository.StockRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class StockService {

    private final StockRepository stockRepo;

    public void saveStockPositionToDB(StockPosition stockPosition)  {

        stockRepo.save(stockPosition);
        log.info("Successfully saved the stock position.");
    }
}

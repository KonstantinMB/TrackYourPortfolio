package com.konstantinmb.trackyourportfolio.api;

import com.konstantinmb.trackyourportfolio.domain.StockPositionRequest;
import com.konstantinmb.trackyourportfolio.domain.mapper.StockPositionMapper;
import com.konstantinmb.trackyourportfolio.service.StockService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@AllArgsConstructor
@Slf4j
public class StockDataApi {

    private final StockService stockService;

    @GetMapping("/stock/info")
    public EntityModel<?> getCurrentStockInfo(@RequestParam String stockSymbol) throws IOException {

        Stock stock = YahooFinance.get(stockSymbol.toUpperCase());
        log.info("Getting info for this stock: " + stock.toString());
        return EntityModel.of(stock);
    }

    @PostMapping("/stock")
    public EntityModel<?> saveStockPosition(@RequestBody StockPositionRequest stockPositionRequest) throws IOException {

        Stock stock = YahooFinance.get(stockPositionRequest.getStockSymbol().toUpperCase());
        log.info(stock.toString());
        stockService.saveStockPositionToDB(StockPositionMapper.toDtoStockPosition(stockPositionRequest));
        return EntityModel.of(stockPositionRequest,
                linkTo(StockDataApi.class).withSelfRel());
    }

}

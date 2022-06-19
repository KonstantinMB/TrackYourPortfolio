package com.konstantinmb.trackyourportfolio.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class StockDataApi {

    @GetMapping("/stock")
    public ResponseEntity<?> fetchStockInfo(@RequestBody String stockName) {

        return ResponseEntity.ok().body("What is the symbol of this stock: " + stockName + " ?");
    }

}

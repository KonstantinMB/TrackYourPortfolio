package com.konstantinmb.trackyourportfolio.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StockDataApi {

    @GetMapping("/stock")
    public ResponseEntity<?> fetchStockInfo() {
        return ResponseEntity.ok().body("Hello");
    }

}

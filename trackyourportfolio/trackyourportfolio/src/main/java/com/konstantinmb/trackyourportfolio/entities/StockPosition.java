package com.konstantinmb.trackyourportfolio.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="stock_positions")
@AllArgsConstructor
@Builder
@Getter
@Setter
public class StockPosition {

    public StockPosition() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_position_id")
    @JsonIgnore
    private Long stockPositionId;

    @Column(name = "stock_symbol")
    private String stockSymbol;

    @Column(name = "stock_name")
    private String stockName;

    @Column(name = "stock_price")
    private BigDecimal stockPrice;

    @Column(name = "stock_amount")
    private Long stockAmount;

}

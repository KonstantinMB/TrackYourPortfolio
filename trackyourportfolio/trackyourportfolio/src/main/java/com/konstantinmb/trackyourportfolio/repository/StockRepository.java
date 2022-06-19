package com.konstantinmb.trackyourportfolio.repository;

import com.konstantinmb.trackyourportfolio.entities.StockPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockPosition, Long> {

}

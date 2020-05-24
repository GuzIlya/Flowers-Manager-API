package net.guz.flowersmanagerapi.repository;

import net.guz.flowersmanagerapi.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}

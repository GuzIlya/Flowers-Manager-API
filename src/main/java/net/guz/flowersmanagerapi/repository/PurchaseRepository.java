package net.guz.flowersmanagerapi.repository;

import net.guz.flowersmanagerapi.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}

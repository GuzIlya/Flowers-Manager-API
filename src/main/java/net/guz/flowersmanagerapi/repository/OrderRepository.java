package net.guz.flowersmanagerapi.repository;

import net.guz.flowersmanagerapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

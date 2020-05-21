package net.guz.flowersmanagerapi.repository;

import net.guz.flowersmanagerapi.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}

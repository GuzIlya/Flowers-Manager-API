package net.guz.flowersmanagerapi.repository;

import net.guz.flowersmanagerapi.entity.Category;
import net.guz.flowersmanagerapi.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByShop(Shop shop);
}

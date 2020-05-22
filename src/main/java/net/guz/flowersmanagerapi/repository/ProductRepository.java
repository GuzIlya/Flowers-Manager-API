package net.guz.flowersmanagerapi.repository;

import net.guz.flowersmanagerapi.entity.Category;
import net.guz.flowersmanagerapi.entity.Product;
import net.guz.flowersmanagerapi.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByShop(Shop shop);
    List<Product> findAllByShopAndCategory(Shop shop, Category category);
}

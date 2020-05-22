package net.guz.flowersmanagerapi.repository;

import net.guz.flowersmanagerapi.entity.Search;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRepository extends JpaRepository<Search, Long> {
}

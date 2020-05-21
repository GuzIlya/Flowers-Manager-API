package net.guz.flowersmanagerapi.repository;

import net.guz.flowersmanagerapi.entity.Florist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FloristRepository extends JpaRepository<Florist, Long> {
    Optional<Florist> findOneByPassword(String name);
}

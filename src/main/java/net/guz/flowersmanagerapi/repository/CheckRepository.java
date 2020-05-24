package net.guz.flowersmanagerapi.repository;

import net.guz.flowersmanagerapi.entity.Check;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckRepository extends JpaRepository<Check, Long> {
}

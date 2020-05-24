package net.guz.flowersmanagerapi.repository;

import net.guz.flowersmanagerapi.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}

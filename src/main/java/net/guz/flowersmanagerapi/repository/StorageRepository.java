package net.guz.flowersmanagerapi.repository;

import net.guz.flowersmanagerapi.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Storage, Long> {
}

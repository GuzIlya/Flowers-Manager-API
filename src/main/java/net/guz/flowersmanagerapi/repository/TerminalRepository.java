package net.guz.flowersmanagerapi.repository;

import net.guz.flowersmanagerapi.entity.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TerminalRepository extends JpaRepository<Terminal, Long> {
    Optional<Terminal> findOneByLogin(String login);
}

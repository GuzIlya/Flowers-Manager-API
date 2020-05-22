package net.guz.flowersmanagerapi.repository;

import net.guz.flowersmanagerapi.entity.Florist;
import net.guz.flowersmanagerapi.entity.Order;
import net.guz.flowersmanagerapi.entity.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByFloristAndTerminal(Florist florist, Terminal terminal);
    List<Order> findAllByFloristAndTerminalAndDate(Florist florist, Terminal terminal, String date);
    List<Order> findAllByFloristAndTerminalAndTime(Florist florist, Terminal terminal, String time);
    List<Order> findAllByFloristAndTerminalAndCustomer(Florist florist, Terminal terminal, String customer);
    List<Order> findAllByFloristAndTerminalAndAddress(Florist florist, Terminal terminal, String address);
    List<Order> findAllByFloristAndTerminalAndPrice(Florist florist, Terminal terminal, String price);
    Optional<Order> findOneByFloristAndTerminalAndId(Florist florist, Terminal terminal, Long id);
}

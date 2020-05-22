package net.guz.flowersmanagerapi.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import net.guz.flowersmanagerapi.dto.OrderDto;
import net.guz.flowersmanagerapi.dto.SearchDto;
import net.guz.flowersmanagerapi.dto.SortDto;
import net.guz.flowersmanagerapi.entity.Florist;
import net.guz.flowersmanagerapi.entity.Order;
import net.guz.flowersmanagerapi.entity.Terminal;
import net.guz.flowersmanagerapi.repository.*;
import net.guz.flowersmanagerapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FloristRepository floristRepository;

    @Autowired
    private TerminalRepository terminalRepository;

    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private SortRepository sortRepository;

    @Override
    public List<Order> getOrdersByFloristAndTerminal(Jws<Claims> claims) {
        Optional<Florist> floristCandidate = floristRepository.findById(Long.parseLong(claims.getBody().get("florist_id").toString()));
        Optional<Terminal> terminalCandidate = terminalRepository.findById(Long.parseLong(claims.getBody().get("terminal_id").toString()));

        return orderRepository.findAllByFloristAndTerminal(floristCandidate.get(), terminalCandidate.get());
    }

    @Override
    public List<OrderDto> getOrdersByFloristAndTerminalByIdAsc(Jws<Claims> claims) {
        Optional<Florist> floristCandidate = floristRepository.findById(Long.parseLong(claims.getBody().get("florist_id").toString()));
        Optional<Terminal> terminalCandidate = terminalRepository.findById(Long.parseLong(claims.getBody().get("terminal_id").toString()));

        List<Order> orders = orderRepository.findAllByFloristAndTerminal(floristCandidate.get(), terminalCandidate.get());

        Collections.sort(orders, Comparator.comparing(Order::getId));

        return OrderDto.from(orders);
    }

    @Override
    public List<OrderDto> getOrderById(Jws<Claims> claims, Long id) {
        Optional<Florist> floristCandidate = floristRepository.findById(Long.parseLong(claims.getBody().get("florist_id").toString()));
        Optional<Terminal> terminalCandidate = terminalRepository.findById(Long.parseLong(claims.getBody().get("terminal_id").toString()));

        Optional<Order> order = orderRepository.findOneByFloristAndTerminalAndId(floristCandidate.get(), terminalCandidate.get(), id);

        if(order.isPresent())
            return OrderDto.from(Arrays.asList(order.get()));
        else throw new IllegalArgumentException("No such order");
    }

    @Override
    public List<OrderDto> getOrdersByDate(Jws<Claims> claims, String date) {
        Optional<Florist> floristCandidate = floristRepository.findById(Long.parseLong(claims.getBody().get("florist_id").toString()));
        Optional<Terminal> terminalCandidate = terminalRepository.findById(Long.parseLong(claims.getBody().get("terminal_id").toString()));

        List<Order> orders = orderRepository.findAllByFloristAndTerminalAndDate(floristCandidate.get(), terminalCandidate.get(), date);

        Collections.sort(orders, Comparator.comparing(Order::getId));

        return OrderDto.from(orders);
    }

    @Override
    public List<OrderDto> getOrdersByTime(Jws<Claims> claims, String time) {
        Optional<Florist> floristCandidate = floristRepository.findById(Long.parseLong(claims.getBody().get("florist_id").toString()));
        Optional<Terminal> terminalCandidate = terminalRepository.findById(Long.parseLong(claims.getBody().get("terminal_id").toString()));

        List<Order> orders = orderRepository.findAllByFloristAndTerminalAndTime(floristCandidate.get(), terminalCandidate.get(), time);

        Collections.sort(orders, Comparator.comparing(Order::getId));

        return OrderDto.from(orders);
    }

    @Override
    public List<OrderDto> getOrdersByCustomer(Jws<Claims> claims, String customer) {
        Optional<Florist> floristCandidate = floristRepository.findById(Long.parseLong(claims.getBody().get("florist_id").toString()));
        Optional<Terminal> terminalCandidate = terminalRepository.findById(Long.parseLong(claims.getBody().get("terminal_id").toString()));

        List<Order> orders = orderRepository.findAllByFloristAndTerminalAndCustomer(floristCandidate.get(), terminalCandidate.get(), customer);

        Collections.sort(orders, Comparator.comparing(Order::getId));

        return OrderDto.from(orders);
    }

    @Override
    public List<OrderDto> getOrdersByAddress(Jws<Claims> claims, String address) {
        Optional<Florist> floristCandidate = floristRepository.findById(Long.parseLong(claims.getBody().get("florist_id").toString()));
        Optional<Terminal> terminalCandidate = terminalRepository.findById(Long.parseLong(claims.getBody().get("terminal_id").toString()));

        List<Order> orders = orderRepository.findAllByFloristAndTerminalAndAddress(floristCandidate.get(), terminalCandidate.get(), address);

        Collections.sort(orders, Comparator.comparing(Order::getId));

        return OrderDto.from(orders);
    }

    @Override
    public List<OrderDto> getOrdersByPrice(Jws<Claims> claims, String price) {
        Optional<Florist> floristCandidate = floristRepository.findById(Long.parseLong(claims.getBody().get("florist_id").toString()));
        Optional<Terminal> terminalCandidate = terminalRepository.findById(Long.parseLong(claims.getBody().get("terminal_id").toString()));

        List<Order> orders = orderRepository.findAllByFloristAndTerminalAndPrice(floristCandidate.get(), terminalCandidate.get(), price);

        Collections.sort(orders, Comparator.comparing(Order::getId));

        return OrderDto.from(orders);
    }

    @Override
    public List<SortDto> getSorts() {
        return SortDto.from(sortRepository.findAll());
    }

    @Override
    public List<SearchDto> getSearches() {
        return SearchDto.from(searchRepository.findAll());
    }
}

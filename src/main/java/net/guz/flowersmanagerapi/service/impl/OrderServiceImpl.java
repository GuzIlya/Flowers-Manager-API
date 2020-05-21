package net.guz.flowersmanagerapi.service.impl;

import net.guz.flowersmanagerapi.entity.Order;
import net.guz.flowersmanagerapi.repository.OrderRepository;
import net.guz.flowersmanagerapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrdersByIdDesc() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}

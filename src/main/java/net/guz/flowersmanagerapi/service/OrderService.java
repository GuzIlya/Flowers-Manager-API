package net.guz.flowersmanagerapi.service;

import net.guz.flowersmanagerapi.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrdersByIdDesc();
    List<Order> getOrders();
}

package net.guz.flowersmanagerapi.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import net.guz.flowersmanagerapi.dto.*;
import net.guz.flowersmanagerapi.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrdersByFloristAndTerminal(Jws<Claims> claims);
    List<OrderDto> getOrdersByFloristAndTerminalByIdAsc(Jws<Claims> claims);
    List<OrderDto> getOrderById(Jws<Claims> claims, Long id);
    List<OrderDto> getOrdersByDate(Jws<Claims> claims, String date);
    List<OrderDto> getOrdersByTime(Jws<Claims> claims, String time);
    List<OrderDto> getOrdersByCustomer(Jws<Claims> claims, String customer);
    List<OrderDto> getOrdersByAddress(Jws<Claims> claims, String address);
    List<OrderDto> getOrdersByPrice(Jws<Claims> claims, String price);
    List<SortDto> getSorts();
    List<SearchDto> getSearches();
    List<CategoryDto> getCategories(Jws<Claims> claims);
    List<ProductDto> getProducts(Jws<Claims> claims, Long categoryId);
}

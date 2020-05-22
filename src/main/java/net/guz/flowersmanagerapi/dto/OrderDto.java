package net.guz.flowersmanagerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.guz.flowersmanagerapi.entity.Order;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Long id;

    private String date;

    private String time;

    private String address;

    private String customer;

    private String price;

    public static OrderDto from(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .date(order.getDate())
                .time(order.getTime())
                .address(order.getAddress())
                .customer(order.getCustomer())
                .price(order.getPrice())
                .build();
    }

    public static List<OrderDto> from(List<Order> orders) {
        return orders.stream().map(OrderDto::from).collect(Collectors.toList());
    }
}

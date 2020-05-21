package net.guz.flowersmanagerapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "orders")
public class Order extends BaseEntity {
    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "address")
    private String address;

    @Column(name = "customer")
    private String customer;

    @Column(name = "price")
    private String price;
}

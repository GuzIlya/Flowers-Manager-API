package net.guz.flowersmanagerapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


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

    @Column(name = "price")
    private String price;

    @Column(name = "customer")
    private String customer;

    @Column(name = "customer_number")
    private String customerNumber;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "receiver_number")
    private String receiverNumber;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "notes", length = 1024)
    private String notes;

    @Column(name = "courier")
    private String courier;

    @Column(name = "pay_status")
    private Boolean payStatus;

    @ManyToOne(optional = false)
    @JoinColumn(name = "florist_id")
    private Florist florist;

    @ManyToOne(optional = false)
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;

    @ManyToOne()
    @JoinColumn(name = "check_id")
    private Check check;
}

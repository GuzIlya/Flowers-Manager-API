package net.guz.flowersmanagerapi.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.guz.flowersmanagerapi.entity.BaseEntity;
import net.guz.flowersmanagerapi.entity.Shop;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "terminals")
public class Terminal extends BaseEntity {
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @OneToMany(mappedBy = "terminal", fetch = FetchType.EAGER)
    private List<Order> orders;
}

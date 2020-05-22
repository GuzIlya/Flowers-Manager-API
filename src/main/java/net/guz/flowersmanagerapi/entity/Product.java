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
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
}

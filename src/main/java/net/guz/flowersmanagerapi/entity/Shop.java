package net.guz.flowersmanagerapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "shops")
public class Shop extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "shop", fetch = FetchType.EAGER)
    private List<Terminal> terminals;
}

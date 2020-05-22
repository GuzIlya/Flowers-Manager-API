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
@Table(name = "sorts")
public class Sort extends BaseEntity{
    @Column(name = "title")
    private String title;

    @Column(name = "value")
    private String value;
}

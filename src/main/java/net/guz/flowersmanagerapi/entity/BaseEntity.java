package net.guz.flowersmanagerapi.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created", columnDefinition = "TIMESTAMP default NOW()")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated", columnDefinition = "TIMESTAMP default NOW()")
    private Date updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "VARCHAR(25) default 'ACTIVE'")
    private Status status;
}

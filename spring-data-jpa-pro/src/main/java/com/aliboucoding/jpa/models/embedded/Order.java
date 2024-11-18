package com.aliboucoding.jpa.models.embedded;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_order") // order is a reserved keywork in Spring Boot, we must rename it
public class Order {

    @EmbeddedId //Use the @Embeddable OrderId class. We can use composite id inside OrderId as well
    private OrderId id;

    @Embedded
    private Address address;

    private String orderInfo;
    private String anotherField;
}

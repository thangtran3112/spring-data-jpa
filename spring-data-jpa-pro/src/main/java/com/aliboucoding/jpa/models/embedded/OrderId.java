package com.aliboucoding.jpa.models.embedded;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Embeddable class must implement Serializable interface
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrderId implements Serializable {

    // Composite primary key: (username, orderDate)
    private String username;
    private LocalDateTime orderDate;
}
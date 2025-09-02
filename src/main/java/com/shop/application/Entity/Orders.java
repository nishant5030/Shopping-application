package com.shop.application.Entity;

import java.sql.Date;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Orders {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    private String product;
    private Integer quantity;
    private String description;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "payment_status")
    private String paymentStatus;

    @JsonProperty("customerId")
    public UUID getCustomerId() {
        return customer != null ? customer.getId() : null;
    }
    

}

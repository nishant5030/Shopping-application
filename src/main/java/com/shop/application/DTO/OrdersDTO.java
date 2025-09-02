package com.shop.application.DTO;

import java.util.Date;
import java.util.UUID;

import com.shop.application.Entity.Customer;

import lombok.Data;

@Data
public class OrdersDTO {

    private UUID id;
    private Customer customer;

    private String product;
    private Integer quantity;
    private String description;
    private Date orderDate;
    private String paymentStatus;

}

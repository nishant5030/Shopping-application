package com.shop.application.DTO;

import java.util.List;
import java.util.UUID;

import com.shop.application.Entity.Orders;

import lombok.Data;

@Data
public class CustomerDTO {


    private UUID id;
    private String name;
    private String email;
    private List<Orders> orders;

}

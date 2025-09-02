package com.shop.application.Entity;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private UUID id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Orders> orders;
    

}

package com.shop.application.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.shop.application.Entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, UUID>, JpaSpecificationExecutor<Orders> {

}

package com.shop.application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.application.Entity.Orders;
import com.shop.application.Service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    public OrdersService ordersService;

    @GetMapping
    public ResponseEntity<List<Orders>> listAllOrders(){
        return new ResponseEntity<>(ordersService.listAllOrders(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Orders> saveOrders(@RequestParam(required = true) String customer , @RequestBody Orders orders ){
        return new ResponseEntity<>(ordersService.saveOrder(customer ,orders),HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Orders> listOrdersById(@PathVariable String orderId){
        return new ResponseEntity<>(ordersService.findOrdersById(orderId),HttpStatus.OK);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Orders> updateOrders(@PathVariable String orderId , @RequestBody Orders orders ){
        return new ResponseEntity<>(ordersService.updateOrder(orderId ,orders),HttpStatus.CREATED);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrdersById(@PathVariable String orderId){
        ordersService.deleteOrder(orderId);
    }

}

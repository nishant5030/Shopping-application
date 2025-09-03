package com.shop.application.Service;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.util.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.shop.application.Entity.Customer;
import com.shop.application.Entity.Orders;
import com.shop.application.Exception.EntityNotFoundException;
import com.shop.application.Repository.CustomerRepository;
import com.shop.application.Repository.OrdersRepository;

import io.micrometer.common.util.StringUtils;

@Service
public class OrdersService {

    @Autowired
    public OrdersRepository ordersRepository;

    @Autowired
    public CustomerRepository customerRepository;

    public List<Orders> listAllOrders(){
        return ordersRepository.findAll();
    }

    public Orders saveOrder(String customer ,  Orders order){
        validateOrder(customer , order);
        return ordersRepository.save(order);
    }

    public Orders findOrdersById(String orderId){
        return ordersRepository.findById(UUID.fromString(orderId)).orElseThrow(
            () -> new EntityNotFoundException(HttpStatus.NOT_FOUND,"Order with id not found")
        );
    }

    public Orders updateOrder(String orderId , Orders orders){
        Orders existingOrders = findOrdersById(orderId);
        setUpdateableFields(existingOrders, orders);
        validateOrder(existingOrders.getCustomerId().toString(), existingOrders);
        return ordersRepository.save(existingOrders);
    }

    public void deleteOrder(String orderId){
        Orders existingOrders = findOrdersById(orderId);
        ordersRepository.deleteById(existingOrders.getId());
    }

    private void validateOrder(String customer ,Orders orders){

        if(StringUtils.isNotBlank(customer)){
            Customer existingCustomer = customerRepository.findById(UUID.fromString(customer)).orElseThrow(()-> new InternalException("Customer not present"));
            orders.setCustomer(existingCustomer);
            
        }
        else{
            throw new EntityNotFoundException(HttpStatus.NOT_FOUND,"Customer is empty");
        }
    }

    private void setUpdateableFields(Orders existsinOrders , Orders newOrders){
        existsinOrders.setQuantity(newOrders.getQuantity());
        existsinOrders.setDescription(newOrders.getDescription());
    }

}

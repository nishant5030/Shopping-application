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
import org.springframework.web.bind.annotation.RestController;

import com.shop.application.Entity.Customer;
import com.shop.application.Service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<Customer>> fetchAllCustomers(){
        return new ResponseEntity<>(customerService.ListAllCustomers(),HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> fetchCustomerById(@PathVariable String customerId){
        return new ResponseEntity<>(customerService.findCustomerById(customerId),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.saveCustomer(customer),HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String customerId , @RequestBody Customer customer){
        return new ResponseEntity<>(customerService.updateCustomer(customerId, customer),HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable String customerId){
        customerService.deleteCustomer(customerId);
    }


}

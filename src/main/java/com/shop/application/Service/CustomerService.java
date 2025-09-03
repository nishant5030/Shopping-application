package com.shop.application.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.shop.application.Entity.Customer;
import com.shop.application.Exception.EntityNotFoundException;
import com.shop.application.Repository.CustomerRepository;


@Service
public class CustomerService {

    @Autowired
    public CustomerRepository customerRepository;

    public List<Customer> ListAllCustomers() {
        return customerRepository.findAll();        
    }

    public Customer findCustomerById(String customerId){
        return customerRepository.findById(UUID.fromString(customerId)).orElseThrow(
            ()-> new EntityNotFoundException(HttpStatus.NOT_FOUND,"Customer not present")
        );
    }

    public Customer saveCustomer(Customer customer){
        validateCustomer(customer);
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(String customerId , Customer customer){

        Customer existingCustomer = findCustomerById(customerId);

        setUpdateableFields(existingCustomer, customer);
        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(String customerId){
        Customer existingCustomer = findCustomerById(customerId);
        customerRepository.deleteById(existingCustomer.getId());
    }

    private void validateCustomer(Customer customer){
    }

    private void setUpdateableFields(Customer existingCustomer , Customer newCustomer){

        existingCustomer.setEmail(newCustomer.getEmail());
        existingCustomer.setName(newCustomer.getName());

    }

}

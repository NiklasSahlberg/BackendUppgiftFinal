package com.example.backenduppgiftfinal.controllers;

import com.example.backenduppgiftfinal.models.Customers;
import com.example.backenduppgiftfinal.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(path ="/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping()
    public String addNewUser(@RequestBody Customers customers){


        customerRepository.save(customers);

        return customers.getName() + " is saved";
    }



    @RequestMapping()
    public Iterable<Customers> getAllCustomers(){
        return customerRepository.findAll();
    }


    @RequestMapping("/:id")
    public Customers getCustomerById(@PathParam("id") long id) { return customerRepository.findById(id).get(); }
}
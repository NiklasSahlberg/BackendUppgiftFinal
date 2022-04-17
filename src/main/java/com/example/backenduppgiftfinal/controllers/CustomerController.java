package com.example.backenduppgiftfinal.controllers;

import com.example.backenduppgiftfinal.models.Customers;
import com.example.backenduppgiftfinal.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/add")
    public String addNewUser(@RequestParam String name){
        Customers c = new Customers();
        c.setName(name);

        customerRepository.save(c);

        return name + " is saved";
    }


    @RequestMapping("/all")
    public Iterable<Customers> getAllCustomers(){
        return customerRepository.findAll();
    }


    @RequestMapping("/:id")
    public Customers getCustomerById(@RequestParam long id) { return customerRepository.findById(id).get(); }
}
package com.example.backenduppgiftfinal.controllers;

import com.example.backenduppgiftfinal.models.BuyOrder;
import com.example.backenduppgiftfinal.models.Customers;
import com.example.backenduppgiftfinal.repositories.CustomerRepository;
import com.example.backenduppgiftfinal.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class BuyOrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/add")
    public String addNewOrder(@RequestParam String orderNummer, @RequestParam Long kund) {
        BuyOrder bo = new BuyOrder();
        Customers c = customerRepository.findById(kund).get();


        if (c != null) {
            bo.setCustomers(c);
        }
        orderRepository.save(bo);
        return "Ordernummer med nr: " + orderNummer + " is saved";
    }

    @RequestMapping()
    public Iterable<BuyOrder>allOrders(){
        return orderRepository.findAll();
    }

    @RequestMapping("/:customerId")
    public List<BuyOrder> orderById(long id) {return orderRepository.findByCustomer(id);}

}

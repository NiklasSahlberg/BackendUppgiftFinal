package com.example.backenduppgiftfinal.controllers;


import com.example.backenduppgiftfinal.models.BuyOrder;
import com.example.backenduppgiftfinal.models.Customers;
import com.example.backenduppgiftfinal.models.Items;
import com.example.backenduppgiftfinal.repositories.CustomerRepository;
import com.example.backenduppgiftfinal.repositories.ItemRepository;
import com.example.backenduppgiftfinal.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;

    @RequestMapping("/add")
    public String addItem(@RequestParam String name)
    {
        Items i = new Items();

        i.setName(name);


        itemRepository.save(i);

        return "Varan " + name + " sparad";
    }

    @RequestMapping("/all")
    public Iterable<Items> allItems()
    {
        return itemRepository.findAll();
    }

    @RequestMapping ("/:id")
    public Items itemById(@RequestParam long id) { return itemRepository.findById(id).get(); }


    @PostMapping("/buy") public String buyItems(@RequestBody BuyOrder bo)
    {
        bo.setCustomer(bo.getCustomer());
        Customers c = customerRepository.findById(bo.getCustomer()).get();
        Items i = itemRepository.findById(bo.getItem()).get();

        if (c != null) {
            bo.setCustomers(c);
        }
        if (i != null) {
            bo.setItems(i);
        }


        if (i != null) {
            bo.setItems(i);
        }

        orderRepository.save(bo);
        return "order sparad";
    }




}
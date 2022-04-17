package com.example.backenduppgiftfinal.controllers;


import com.example.backenduppgiftfinal.models.Items;
import com.example.backenduppgiftfinal.repositories.CustomerRepository;
import com.example.backenduppgiftfinal.repositories.ItemRepository;
import com.example.backenduppgiftfinal.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



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

    @RequestMapping ("/items/:id")
    public Items itemById(@RequestParam long id) { return itemRepository.findById(id).get(); }

   /* @RequestMapping("/buy")
    public String buyItem(@RequestParam long customerId, @RequestParam long itemId)
    {
        BuyOrder bo = new BuyOrder();
        bo.setCustomerId(customerId);
        Customers c = customerRepository.findById(customerId).get();
        Items i = itemRepository.findById(itemId).get();

        if (c != null) {
            bo.setCustomers(c);
        }
        if (i != null) {
            bo.setItemsList((List<Items>) i);
        }
        orderRepository.save(bo);
        return "order sparad";
    }


    */

}
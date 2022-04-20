package com.example.backenduppgiftfinal.models;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class BuyOrder {
    @Id
    @GeneratedValue
    private Long id;
    private Long item;
    private Long customer;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn
    Customers customers;

    @ManyToOne
    @JoinColumn
    private Items items;
}

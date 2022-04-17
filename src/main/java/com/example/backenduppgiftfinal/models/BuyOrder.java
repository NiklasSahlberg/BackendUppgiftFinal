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
    private String item;
    private Long customerId;
  /*  @Autowired
    private String ordernummer;

   */

    @ManyToOne
    @JoinColumn
    Customers customers;


   /* @OneToMany
    @JoinColumn
    private Items items;



    */


  /* @ManyToMany
    @JoinTable
    private List<Items> itemsList;

   */
}

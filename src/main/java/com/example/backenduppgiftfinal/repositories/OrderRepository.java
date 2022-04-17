package com.example.backenduppgiftfinal.repositories;

import com.example.backenduppgiftfinal.models.BuyOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<BuyOrder, Long> {
}

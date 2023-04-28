package com.example.demo.Repository;

import com.example.demo.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    //Orders findOrdersByOrder_id(Integer id);

    Orders findOrdersByAddress_Id(Integer id);
}

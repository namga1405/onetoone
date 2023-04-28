package com.example.demo.Service;

import com.example.demo.Entity.Orders;
import com.example.demo.dto.OrdersDto;
import com.example.demo.dto.ResultDto;

import java.util.List;

public interface OrdersService {
    List<OrdersDto> getallOrder();

    ResultDto createOrders(Orders orders);

//    OrdersDto findOrdersbyId(Integer id);

    OrdersDto findOrdersByAddressId(Integer id);
}

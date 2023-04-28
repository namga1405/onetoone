package com.example.demo.Service;


import com.example.demo.Entity.Orders;
import com.example.demo.Exception.Exception;
import com.example.demo.Repository.OrdersRepository;
import com.example.demo.dto.OrdersDto;
import com.example.demo.dto.ResultDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService{
    
    private final OrdersRepository ordersRepository;
    
    private final ModelMapper mapper;

    @Override
    public List<OrdersDto> getallOrder()  throws Exception {

            List<Orders> OrdersList = ordersRepository.findAll(); //  1 mảng Orders
            List<OrdersDto> OrdersDtoList = new ArrayList<>();  //  1 mảng OrdersDto trống
            for(Orders i : OrdersList){ // map từng phần tử Orders thành OrdersDto
                OrdersDto x = mapper.map(i,OrdersDto.class);
                OrdersDtoList.add(x);                         // thêm vào mảng trống
            }
            return OrdersDtoList;
    }

    @Override
    public ResultDto createOrders(Orders orders) {
        try{
            ordersRepository.save(orders);
        }
        catch(Exception e){
            return ResultDto.builder().code(400).message("Error").build();
        }
        return ResultDto.builder().code(200).message("Orders added").build();
    }

//    @Override
//    public OrdersDto findOrdersbyId(Integer id) {
//        Orders orders = ordersRepository.findOrdersByOrder_id(id);
//        if(orders==null) {
//            throw new Exception(400,"no customer found");
//        }
//        else{
//            return mapper.map(orders, OrdersDto.class);
//        }
//    }


    @Override
    public OrdersDto findOrdersByAddressId(Integer id) {
        Orders orders = ordersRepository.findOrdersByAddress_Id(id);
        if(orders==null) {
            throw new Exception(400,"no orders found");
        }
        else{
            return mapper.map(orders, OrdersDto.class);
        }
    }

}

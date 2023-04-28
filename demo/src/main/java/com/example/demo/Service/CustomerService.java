package com.example.demo.Service;

import com.example.demo.Entity.Customer;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ResultDto;


import java.util.List;

public interface CustomerService {
    List<CustomerDto> getallCustomer();

    ResultDto createCustomer(Customer customer);

    public void deleteCustomerbyId(Integer id);

    CustomerDto findCustomerbyId(Integer id);

    CustomerDto findCustomerbyAddressId(Integer id);


}




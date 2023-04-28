package com.example.demo.Service;

import com.example.demo.Entity.Customer;
import com.example.demo.Exception.Exception;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ResultDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository CustomerRepository;

    private final ModelMapper mapper;

    @Override
    public List<CustomerDto> getallCustomer() throws Exception{
        List<Customer> CustomerList = CustomerRepository.findAll(); //  1 mảng Customer
        List<CustomerDto> CustomerDtoList = new ArrayList<>();  //  1 mảng CustomerDto trống
        for(Customer i : CustomerList){ // map từng phần tử Customer thành CustomerDto
            CustomerDto x = mapper.map(i,CustomerDto.class);
            CustomerDtoList.add(x);                         // thêm vào mảng trống
        }
        return CustomerDtoList;
    }


    public ResultDto createCustomer(Customer customer) {
        try{
            CustomerRepository.save(customer);
        }
    catch(Exception e){
        return ResultDto.builder().code(400).message("Error").build();
    }
        return ResultDto.builder().code(200).message("Customer added").build();
    }

    @Override
    @Transactional
    public void deleteCustomerbyId(Integer id) {
        Customer customer = CustomerRepository.findCustomerById(id);
        if(customer==null) {
            throw new Exception(400, "data doesn't exist");
        }
        else {
            CustomerRepository.deleteCustomerById(id);
        }
    }

    @Override
    public CustomerDto findCustomerbyId(Integer id) {
        Customer Customer1 = CustomerRepository.findCustomerById(id);
        if(Customer1==null) {
            throw new Exception(400,"no customer found");
        }
        else{
            return mapper.map(Customer1,CustomerDto.class);
        }
    }

    @Override
    public CustomerDto findCustomerbyAddressId(Integer id) {
        Customer Customer = CustomerRepository.findCustomerByAddress_Id(id);
        if(Customer == null) {
            throw new Exception(400, "no customer found");
        }
        else{
            return mapper.map(Customer,CustomerDto.class);
        }
    }


}







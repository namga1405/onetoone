package com.example.demo.Repository;

import com.example.demo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findCustomerById(Integer id);
    void deleteCustomerById(Integer id);
    Customer findCustomerByAddress_Id(Integer id);




}

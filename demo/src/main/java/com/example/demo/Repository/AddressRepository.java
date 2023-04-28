package com.example.demo.Repository;

import com.example.demo.Entity.Address;
import com.example.demo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {



}

package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {




    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//        CustomerRepository customerRepository = context.getBean(CustomerRepository.class);

//        System.out.println("All user with the age between 19 to 20");
//        customerRepository.findAllByAgeBetween(19,20)
//                .forEach(System.out::println);
//
//        System.out.println("=======================================");
//        customerRepository.findCustomerById(1)
//                .forEach(System.out::println);

    }
}


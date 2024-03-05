package com.springboot.demoMongoDB.controller;

import com.springboot.demoMongoDB.repository.CustomerRepository;
import com.springboot.demoMongoDB.model.Customer;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customers")
    public Customer save(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    // Get hostname
    @SneakyThrows
    @GetMapping("/getHost")
    public String getHost(){
        InetAddress ia = InetAddress.getLocalHost();
        return  "Hostname: " + ia.getHostName() + " Hostadress: " + ia.getHostAddress();
    }
}

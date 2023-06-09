package com.example.demo.controller;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @GetMapping(value = "/customers")
    public String list(Model model){
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customers/customerList";
    }
}

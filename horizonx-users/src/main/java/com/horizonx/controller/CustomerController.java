package com.horizonx.controller;

import com.horizonx.entity.Customer;
import com.horizonx.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomer() {
       return customerService.getAllCustomers();
    }
    @GetMapping("/{custId}")
    public Customer getCustomerById(@PathVariable Long custId) {
        return customerService.getByCustId(custId);
    }

    @DeleteMapping("/custId")
    public String deleteCustomerById(@PathVariable Long custId) {
         customerService.removeCustomer(custId);
         return "Successfully deleted!";
    }

}

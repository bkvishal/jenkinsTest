package com.horizonx.service;

import com.horizonx.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer getByCustId(Long custId);
    List<Customer> getAllCustomers();
    Customer addCustomer(Customer customer);
    void removeCustomer(Long custId);
}

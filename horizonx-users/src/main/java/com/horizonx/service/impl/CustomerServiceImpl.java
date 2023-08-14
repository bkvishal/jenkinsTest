package com.horizonx.service.impl;

import com.horizonx.entity.Customer;
import com.horizonx.repository.CustomerDao;
import com.horizonx.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerRepository;

    public CustomerServiceImpl(CustomerDao customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer getByCustId(Long custId) {
        return customerRepository.findById(custId).orElseThrow(() -> new RuntimeException("No customer found with this id"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void removeCustomer(Long custId) {
        customerRepository.deleteById(custId);
    }

}

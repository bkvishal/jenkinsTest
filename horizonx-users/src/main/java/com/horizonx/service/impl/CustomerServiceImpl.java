package com.horizonx.service.impl;

import com.horizonx.entity.Customer;
import com.horizonx.repository.CustomerDao;
import com.horizonx.repository.CustomerRepository;
import com.horizonx.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    /*private final CustomerRepository customerRepository;*/

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

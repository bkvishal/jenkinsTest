package com.horizonx.repository;

import com.horizonx.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDao {
    List<Customer> customerList = new ArrayList<>();
    public List<Customer> findAll() {

        customerList.add(new Customer(1L, "Shiv", "Paramdham", "Universe", 0));
        customerList.add(new Customer(2L, "Max", "West coast", "US", 29));
        customerList.add(new Customer(3L, "goku", "NYC", "UK", 26));
        customerList.add(new Customer(4L, "entium", "GZB", "India", 27));
        return customerList;
    }

    public Optional<Customer> findById(Long custId) {
         //customerList.stream().filter(customer -> customer.getCustId().equals(custId)).findFirst().orElseThrow(() -> new RuntimeException("User not found"));
        return customerList.stream().filter(customer -> customer.getCustId().equals(custId)).findAny();
    }

    public Customer save(Customer customer) {
        customerList.add(customer);
        return customer;
    }

    public void deleteById(Long custId) {
        Customer customer1 = customerList.stream().filter(customer -> customer.getCustId().equals(custId)).findFirst().get();
        customerList.remove(customer1);
    }
}

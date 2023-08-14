package com.horizonx.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.horizonx.entity.Customer;
import com.horizonx.repository.CustomerDao;
import com.horizonx.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
@SpringBootTest
public class CustomerServiceImplTest {

    @Mock
    private CustomerDao customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;


    @Test
    public void testGetByCustId() {
        // given
        Long custId = 1L;
        Customer customer = new Customer(1L, "Shiv", "Paramdham", "Universe", 0);

        // when
        when(customerRepository.findById(custId)).thenReturn(Optional.of(customer));
        Customer actualCustomer = customerService.getByCustId(custId);

        // then
        Assertions.assertEquals(customer, actualCustomer);
    }

    @Test
    public void testGetByCustIdNoCustomerFound() {
        // given
        Long custId = 1L;

        // when
        when(customerRepository.findById(custId)).thenReturn(Optional.empty());

        // then
        Assertions.assertThrows(RuntimeException.class, () -> customerService.getByCustId(custId));
    }

    @Test
    public void testGetAllCustomers() {
        // given
        List<Customer> customers = Arrays.asList(
                new Customer(1L, "Shiv", "Paramdham", "Universe", 0),
                new Customer(2L, "Max", "West coast", "US", 29)
        );

        // when
        when(customerRepository.findAll()).thenReturn(customers);
        List<Customer> actualCustomers = customerService.getAllCustomers();

        // then
        Assertions.assertEquals(customers, actualCustomers);
    }

    @Test
    public void testAddCustomer() {
        // given
        Customer customer = new Customer(1L, "Shiv", "Paramdham", "Universe", 0);

        // when
        when(customerRepository.save(customer)).thenReturn(new Customer(2L, "Max", "West coast", "US", 29));
        Customer actualCustomer = customerService.addCustomer(customer);

        // then
        Assertions.assertEquals(2L, actualCustomer.getCustId());
        Assertions.assertEquals("Max", actualCustomer.getCustomerName());
        Assertions.assertEquals("West coast", actualCustomer.getAddress());
    }

    @Test
    public void testRemoveCustomer() {
        // given
        Long custId = 1L;

        // when
        customerService.removeCustomer(custId);

        // then
        Assertions.assertDoesNotThrow(() -> customerRepository.deleteById(custId));
    }
}

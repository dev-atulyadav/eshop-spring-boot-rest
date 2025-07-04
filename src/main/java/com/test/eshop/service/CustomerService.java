package com.test.eshop.service;

import com.test.eshop.dto.Customer;
import com.test.eshop.response.ResponseStructure;

/**
 * @author Atul
 */
public interface CustomerService {
    Customer findByEmail(String email);

    ResponseStructure<Customer> save(Customer customer);

    Customer findById(Long id);

    void deleteById(Long id);
}

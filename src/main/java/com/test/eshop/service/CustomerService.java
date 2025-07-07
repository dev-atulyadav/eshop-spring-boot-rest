package com.test.eshop.service;

import com.test.eshop.dto.Customer;
import com.test.eshop.response.ResponseStructure;

/**
 * @author Atul
 */
public interface CustomerService {
    ResponseStructure<Customer> findByEmailCustomerService(String email);

    ResponseStructure<Customer> saveCustomerService(Customer customer);

    ResponseStructure<Customer> findByIdCustomerService(Long id);

    ResponseStructure<Boolean> deleteByIdCustomerService(Long id);

    ResponseStructure<Customer> updateCustomerService(Customer customer);

    ResponseStructure<Customer> LoginCustomerService(Customer customer);
}

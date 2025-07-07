package com.test.eshop.dao;

import java.util.List;

import com.test.eshop.dto.Customer;

/**
 * @author Atul
 */
public interface CustomerDao {

    Customer findByEmailCustomerDao(String email);

    Customer saveCustomerDao(Customer customer);

    Customer findByIdCustomerDao(Long id);

    void deleteByIdCustomerDao(Long id);

    List<Customer> findAllCustomerDao();

    Customer updateCustomerDao(Customer customer);
}

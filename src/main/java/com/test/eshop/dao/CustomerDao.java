package com.test.eshop.dao;

import java.util.List;

import com.test.eshop.dto.Customer;

/**
 * @author Atul
 */
public interface CustomerDao {

    Customer findByEmail(String email);

    Customer save(Customer customer);

    Customer findById(Long id);

    void deleteById(Long id);

    List<Customer> findAll();
}

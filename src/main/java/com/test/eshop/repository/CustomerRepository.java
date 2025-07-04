package com.test.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.eshop.dto.Customer;

/**
 * @author Atul
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String email);
}

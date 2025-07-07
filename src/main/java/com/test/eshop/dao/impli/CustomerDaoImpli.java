package com.test.eshop.dao.impli;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.eshop.dao.CustomerDao;
import com.test.eshop.dto.Customer;
import com.test.eshop.repository.CustomerRepository;

/**
 * @author Atul
 */
@Repository
public class CustomerDaoImpli implements CustomerDao {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findByEmailCustomerDao(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Customer saveCustomerDao(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findByIdCustomerDao(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteByIdCustomerDao(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAllCustomerDao() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomerDao(Customer customer) {
        return customerRepository.save(customer);
    }
}
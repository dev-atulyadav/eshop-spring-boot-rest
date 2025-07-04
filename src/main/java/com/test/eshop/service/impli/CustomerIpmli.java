package com.test.eshop.service.impli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.test.eshop.dao.CustomerDao;
import com.test.eshop.dto.Customer;
import com.test.eshop.response.ResponseStructure;
import com.test.eshop.service.CustomerService;
import com.test.eshop.validation.DataValidation;

/**
 * @author Atul
 */
@Service
public class CustomerIpmli implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private DataValidation dataValidation;

    @Autowired
    private ResponseStructure<Customer> responseStructure;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Customer findByEmail(String email) {
        return customerDao.findByEmail(email);
    }

    @Override
    public ResponseStructure<Customer> save(Customer customer) {
        if (dataValidation.isValidEmail(customer.getEmail()) && dataValidation.isValidPassword(customer.getPassword())
                && dataValidation.isValidPhone(customer.getPhone())) {
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            customerDao.save(customer);
            responseStructure.setMessage("Customer saved successfully");
            responseStructure.setData(customer);
            responseStructure.setStatus("success");
            responseStructure.setError(null);
            return responseStructure;
        } else {
            responseStructure.setMessage("Please check your email and password!");
            responseStructure.setData(customer);
            responseStructure.setStatus("error");
            responseStructure.setError("Invalid data");
            return responseStructure;
        }
    }

    @Override
    public Customer findById(Long id) {
        return customerDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        customerDao.deleteById(id);
    }
}

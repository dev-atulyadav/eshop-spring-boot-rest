package com.test.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.eshop.dto.Customer;
import com.test.eshop.response.ResponseStructure;
import com.test.eshop.service.CustomerService;

/**
 * @author Atul
 */
@RestController
public class EshopController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/saveCustomer")
    public ResponseStructure<Customer> saveCustomerController(@RequestBody Customer customer) {
        return customerService.save(customer);
    }
}

package com.test.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.eshop.dto.Customer;
import com.test.eshop.response.ResponseStructure;
import com.test.eshop.service.CustomerService;

/**
 * @author Atul
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/customer")
public class EshopController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/saveCustomer")
    public ResponseStructure<Customer> saveCustomerController(@RequestBody Customer customer) {
        return customerService.saveCustomerService(customer);
    }

    @GetMapping(value = "/findByEmail")
    public ResponseStructure<Customer> findByEmailController(@RequestBody Customer customer) {
        return customerService.findByEmailCustomerService(customer.getEmail());
    }

    @GetMapping(value = "/findById")
    public ResponseStructure<Customer> findByIdController(@RequestBody Customer customer) {
        return customerService.findByIdCustomerService(customer.getId());
    }

    @DeleteMapping(value = "/deleteById")
    public ResponseStructure<Boolean> deleteByIdController(@RequestBody Customer customer) {
        return customerService.deleteByIdCustomerService(customer.getId());
    }

    @PutMapping(value = "/update")
    public ResponseStructure<Customer> updateController(@RequestBody Customer customer) {
        return customerService.updateCustomerService(customer);
    }

    @PostMapping(value = "/login")
    public ResponseStructure<Customer> loginController(@RequestBody Customer customer) {
        System.out.println(customer.getPassword());
        System.out.println(customer.getEmail());
        return customerService.LoginCustomerService(customer);
    }
}

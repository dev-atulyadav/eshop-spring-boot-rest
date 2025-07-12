package com.test.eshop.service.impli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.test.eshop.dao.CustomerDao;
import com.test.eshop.dto.Customer;
import com.test.eshop.response.ResponseStructure;
import com.test.eshop.service.CustomerService;
import com.test.eshop.validation.DataValidation;

import jakarta.servlet.http.HttpSession;

/**
 * @author Atul
 */
@Service
public class CustomerServiceIpmli implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private DataValidation dataValidation;

    @Autowired
    private ResponseStructure<Customer> responseStructure;

    @Autowired
    private ResponseStructure<Boolean> responseStructureBoolean;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpSession httpSession;

    @Override
    public ResponseStructure<Customer> findByEmailCustomerService(String email) {
        Customer customer = customerDao.findByEmailCustomerDao(email);
        if (customer != null) {
            responseStructure.setMessage("Customer found successfully");
            responseStructure.setData(customer);
            responseStructure.setStatus("success");
            responseStructure.setError(null);
            return responseStructure;
        } else {
            responseStructure.setMessage("Customer not found! Please check your email");
            responseStructure.setData(null);
            responseStructure.setStatus("error");
            responseStructure.setError("Customer not found");
            return responseStructure;
        }
    }

    @Override
    public ResponseStructure<Customer> saveCustomerService(Customer customer) {
        if (dataValidation.isValidEmail(customer.getEmail()) && dataValidation.isValidPassword(customer.getPassword())
                && dataValidation.isValidPhone(customer.getPhone())) {
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            customerDao.saveCustomerDao(customer);
            customer.setPassword(null); // to avoid password in response
            responseStructure.setMessage("Customer saved successfully");
            responseStructure.setData(customer);
            responseStructure.setStatus("success");
            responseStructure.setError(null);
            return responseStructure;
        } else {
            responseStructure.setMessage("Please check your email, password and phone!");
            responseStructure.setData(customer);
            responseStructure.setStatus("error");
            responseStructure.setError("Invalid data");
            return responseStructure;
        }
    }

    @Override
    public ResponseStructure<Customer> findByIdCustomerService(Long id) {
        Customer customer = customerDao.findByIdCustomerDao(id);
        if (customer != null) {
            responseStructure.setMessage("Customer found successfully");
            responseStructure.setData(customer);
            responseStructure.setStatus("success");
            responseStructure.setError(null);
        } else {
            responseStructure.setMessage("Customer not found! Please check your id");
            responseStructure.setData(null);
            responseStructure.setStatus("error");
            responseStructure.setError("Customer not found");
        }
        return responseStructure;
    }

    @Override
    public ResponseStructure<Boolean> deleteByIdCustomerService(Long id) {
        Customer customer = customerDao.findByIdCustomerDao(id);
        if (customer != null) {
            customerDao.deleteByIdCustomerDao(id);
            responseStructureBoolean.setMessage("Customer deleted successfully");
            responseStructureBoolean.setData(true);
            responseStructureBoolean.setStatus("success");
            responseStructureBoolean.setError(null);
            return responseStructureBoolean;
        } else {
            responseStructureBoolean.setMessage("Customer not found! Please check your id");
            responseStructureBoolean.setData(false);
            responseStructureBoolean.setStatus("error");
            responseStructureBoolean.setError("Customer not found");
            return responseStructureBoolean;
        }
    }

    @Override
    public ResponseStructure<Customer> updateCustomerService(Customer customer) {
        Customer session = (Customer) httpSession.getAttribute("customer");
        if (session != null) {
            if (dataValidation.isValidEmail(customer.getEmail())
                    && dataValidation.isValidPassword(customer.getPassword())
                    && dataValidation.isValidPhone(customer.getPhone())) {
                session.setEmail(customer.getEmail());
                session.setPassword(passwordEncoder.encode(customer.getPassword()));
                session.setPhone(customer.getPhone());
                Customer updatedCustomer = customerDao.updateCustomerDao(session);
                updatedCustomer.setPassword(null);
                responseStructure.setMessage("Customer updated successfully");
                responseStructure.setData(updatedCustomer);
                responseStructure.setStatus("success");
                responseStructure.setError(null);
                return responseStructure;
            } else {
                responseStructure.setMessage("Please check your email and password and phone!");
                responseStructure.setData(null);
                responseStructure.setStatus("error");
                responseStructure.setError("Invalid data");
                return responseStructure;
            }
        } else {
            responseStructure.setMessage("Please login again!");
            responseStructure.setData(null);
            responseStructure.setStatus("error");
            responseStructure.setError("Please login first");
            return responseStructure;
        }
    }

    @Override
    public ResponseStructure<Customer> LoginCustomerService(Customer customer) {
        Customer customer1 = customerDao.findByEmailCustomerDao(customer.getEmail());
        System.out.println(customer1.getPassword());
        if (customer1 != null) {
            customer1.setPassword(null);
            if (passwordEncoder.matches(customer.getPassword(), customer1.getPassword())) {
                responseStructure.setMessage("Login successful");
                responseStructure.setData(customer1);
                responseStructure.setStatus("success");
                responseStructure.setError(null);
                httpSession.setAttribute("customer", customer1);
                return responseStructure;
            } else {
                responseStructure.setMessage("Invalid password");
                responseStructure.setData(null);
                responseStructure.setStatus("error");
                responseStructure.setError("Invalid password");
            }
        }
        responseStructure.setMessage("Invalid email or password");
        responseStructure.setData(null);
        responseStructure.setStatus("error");
        responseStructure.setError("Invalid email or password");
        return responseStructure;
    }
}

package com.test.eshop.validation;

import org.springframework.stereotype.Component;

/**
 * @author Atul
 */
@Component
public class DataValidation {

    public boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    public boolean isValidPassword(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"); // at least 8 characters, one uppercase, one lowercase, one number, one special character
    }

    public boolean isValidPhone(String phone) {
        return phone.matches("^[0-9]{10}$");
    }
}

package com.test.eshop.validation;

import org.springframework.stereotype.Component;

/**
 * @author Atul
 */
@Component
public class DataValidation {

    /**
     * This method is used to validate the email
     * email should be in the format of example@example.com
     * 
     * @param email
     * @return
     */
    public boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    /**
     * This method is used to validate the password
     * password should be at least 8 characters, one uppercase, one lowercase, one number, one special character
     * 
     * @param password
     * @return
     */
    public boolean isValidPassword(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"); // at least 8 characters, one uppercase, one lowercase, one number, one special character
    }

    /**
     * This method is used to validate the phone
     * phone should be in the format of 10 digits
     * 
     * @param phone
     * @return
     */
    public boolean isValidPhone(String phone) {
        return phone.matches("^[0-9]{10}$");
    }
}

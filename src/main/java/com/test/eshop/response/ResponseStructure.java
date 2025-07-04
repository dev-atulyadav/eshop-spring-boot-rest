package com.test.eshop.response;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author Atul
 */
@Data
@Component
public class ResponseStructure<T> {
    private String message;
    private T data;
    private String status;
    private String error;
}

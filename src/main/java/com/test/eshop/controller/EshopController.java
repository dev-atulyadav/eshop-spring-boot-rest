package com.test.eshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Atul
 */
@RestController
public class EshopController {

    @GetMapping(value = "/")
    public String test() {
        return "Hello Test 0";
    }
}

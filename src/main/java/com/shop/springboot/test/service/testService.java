package com.shop.springboot.test.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class testService {
    public HashMap<String, Object> errorsTest(Errors errors) {
        HashMap<String, Object> result = new HashMap<>();
        errors.getFieldErrors().forEach(e -> {
            result.put(e.getField(), e.getDefaultMessage());
        });
        return result;
    }
}

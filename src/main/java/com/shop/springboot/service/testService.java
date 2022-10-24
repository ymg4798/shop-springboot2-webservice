package com.shop.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class testService {
    public List<HashMap<String, Object>> errorsTest(Errors error) {
        List<HashMap<String, Object>> result = new ArrayList<>();
    }


}

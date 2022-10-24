package com.shop.springboot.web;

import com.shop.springboot.web.dto.TestResponseDto;
import com.shop.springboot.web.dto.TestVaild;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class testController {
    @GetMapping("/test")
    public String sample(){
        return "test";
    }

    @PostMapping("/vaild/error")
    public List<HashMap<String, Object>> vaildTest(@Validated TestVaild testVaild, Errors errors) {
        List<HashMap<String, Object>> result = new ArrayList<>();

        if(errors.hasErrors()) {
            return result;
        }
        return result;
    }
}

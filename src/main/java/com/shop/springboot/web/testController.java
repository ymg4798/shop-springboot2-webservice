package com.shop.springboot.web;

import com.shop.springboot.web.dto.TestResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @GetMapping("/test")
    public String sample(){
        return "test";
    }

    @GetMapping("/test/dto")
    public TestResponseDto sample(TestResponseDto dto) {
        return dto;
    }
}

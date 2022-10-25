package com.shop.springboot.test.web;

import com.shop.springboot.test.service.testService;
import com.shop.springboot.test.web.dto.TestVaild;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class testController {

    private final testService testService;

    @GetMapping("/test")
    public String sample(){
        return "test";
    }

    @PostMapping("/vaild/error")
    public HashMap<String, Object> vaildTest(@RequestBody @Validated TestVaild testVaild, Errors errors) {
        HashMap<String, Object> result = new HashMap<>();

        if(errors.hasErrors()) {
            return testService.errorsTest(errors);
        }

        return result;
    }
}

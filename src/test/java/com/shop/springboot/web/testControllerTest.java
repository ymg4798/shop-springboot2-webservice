package com.shop.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class testControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 기본_페이지_로딩() {
        //when
        String body = this.restTemplate.getForObject("/test", String.class);

        //then
        assertThat(body).contains("test");
    }
}

package com.shop.springboot.test.web;

import com.shop.springboot.test.web.dto.TestVaild;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@Slf4j
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

    @Test
    public void Vaild_Error_테스트() {
        //when
        String name = "";
        String password = "";
        TestVaild testVaild = new TestVaild(name, password);

        HashMap<String, Object> responseMap = restTemplate.postForObject("/vaild/error", testVaild, HashMap.class);

        assertThat(responseMap.get("name")).isEqualTo("이름을 입력해 주세요.");
        assertThat(responseMap.get("password")).isEqualTo("비밀번호를 입력해 주세요");
    }
}

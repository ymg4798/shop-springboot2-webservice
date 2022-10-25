package com.shop.springboot.test.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestResponseDtoTest {

    @Test
    public void 롬복_테스트() {

        String responseTest = "test";

        TestResponseDto dto = new TestResponseDto(responseTest);

        assertThat(dto.getResponseTest()).isEqualTo(responseTest);
    }

}

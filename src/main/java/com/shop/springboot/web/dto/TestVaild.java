package com.shop.springboot.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class TestVaild {

    @NotEmpty(message = "이름을 입력해 주세요.")
    private String name;

    @NotEmpty(message = "비밀번호를 입력해 주세요")
    private String password;

}

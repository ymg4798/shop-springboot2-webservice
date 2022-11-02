package com.shop.springboot.board.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class BaseTimeEntityTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void BaseTimeEntity_테스트() {
        //given
        LocalDateTime now = LocalDateTime.of(2022,10,27,15,0,30);
        boardRepository.save(Board.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .createBy("양민규")
                .openYn("Y")
                .build());

        //when
        List<Board> boardList = boardRepository.findAll();

        Board board = boardList.get(0);

        log.info("createdDate = " + board.getCreatedDate() + ", modifiedDate = " + board.getModifiedDate());

        assertThat(board.getCreatedDate()).isAfter(now);
        assertThat(board.getModifiedDate()).isAfter(now);
    }
}

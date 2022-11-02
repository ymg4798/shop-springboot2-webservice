package com.shop.springboot.board.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("test")
public class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @AfterEach
    public void clean() {
        boardRepository.deleteAll();
    }

    @Test
    public void Board_저장_테스트() {
        //given
        String title = "글제목";
        String content = "내용";
        String createBy = "보보";
        String openYn = "Y";

        boardRepository.save(Board.builder()
                .title(title)
                .content(content)
                .createBy(createBy)
                .openYn(openYn)
                .build());

        List<Board> boardList = boardRepository.findAll();

        Board board = boardList.get(0);
        assertThat(board.getTitle()).isEqualTo(title);
        assertThat(board.getContent()).isEqualTo(content);
        assertThat(board.getCreateBy()).isEqualTo(createBy);
        assertThat(board.getOpenYn()).isEqualTo(openYn);

    }
}

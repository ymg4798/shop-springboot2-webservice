package com.shop.springboot.board.web;

import com.shop.springboot.board.domain.Board;
import com.shop.springboot.board.domain.BoardRepository;
import com.shop.springboot.board.web.dto.BoardSaveRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class BoardApiControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void board_저장_테스트() throws Exception{

        String title = "제목";
        String content = "내용";
        String createBy = "양민규";
        String openYn = "Y";
        BoardSaveRequest request = BoardSaveRequest.builder()
                .title(title)
                .content(content)
                .createBy(createBy)
                .openYn(openYn)
                .build();

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity("/shop/api/v1/board", request, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Board> all = boardRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
        assertThat(all.get(0).getCreateBy()).isEqualTo(createBy);
        assertThat(all.get(0).getOpenYn()).isEqualTo(openYn);
    }

}

package com.shop.springboot.board.web;

import com.shop.springboot.board.service.BoardService;
import com.shop.springboot.board.web.dto.BoardSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/shop/api/v1/board")
    public Long save(@RequestBody BoardSaveRequest request) {
        return boardService.save(request);
    }
}

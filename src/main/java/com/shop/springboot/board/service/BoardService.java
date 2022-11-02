package com.shop.springboot.board.service;

import com.shop.springboot.board.domain.BoardRepository;
import com.shop.springboot.board.web.dto.BoardSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardSaveRequest request) {
        return boardRepository.save(request.toEntity()).getId();
    }
}

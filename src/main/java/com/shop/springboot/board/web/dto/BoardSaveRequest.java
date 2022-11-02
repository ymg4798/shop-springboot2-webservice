package com.shop.springboot.board.web.dto;

import com.shop.springboot.board.domain.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequest {
    private String title;
    private String content;
    private String createBy;
    private String openYn;

    @Builder
    public BoardSaveRequest(String title, String content, String createBy, String openYn) {
        this.title = title;
        this.content = content;
        this.createBy = createBy;
        this.openYn = openYn;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .createBy(createBy)
                .openYn(openYn)
                .build();
    }
}

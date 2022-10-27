package com.shop.springboot.board.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    private String createBy;

    private String modifiedBy;

    @Column(length = 1)
    private char openYn;

    @Builder
    Board(String title, String content, String createBy, char openYn) {
        this.title = title;
        this.content = content;
        this.createBy = createBy;
        this.openYn = openYn;
    }
}

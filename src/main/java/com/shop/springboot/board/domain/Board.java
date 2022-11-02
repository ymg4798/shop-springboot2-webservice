package com.shop.springboot.board.domain;

import com.shop.springboot.board.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    private String createBy;

    private String modifiedBy;

    @Column(length = 1, columnDefinition = "char(1)")
    private String openYn;

    @Builder
    public Board(String title, String content, String createBy, String openYn) {
        this.title = title;
        this.content = content;
        this.createBy = createBy;
        this.openYn = openYn;
    }
}

package com.example.library.library.books;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class PageBookId implements Serializable {

    private Long id_chapter;
    private Long id_book;
    private Integer page_number;

    public PageBookId() {}

    public PageBookId(Long id_chapter, Long id_book, Integer page_number){
        this.id_chapter = id_chapter;
        this.id_book = id_book;
        this.page_number = page_number;
    }
}
package com.example.library.library.books;

import com.example.library.library.books.request.PageRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Table(name = "pages_book")
@Entity(name = "pages_book")
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class PageBook {

    @EmbeddedId
    private PageBookId id;

    @ManyToOne
    @MapsId("id_chapter_book")  // Maps the idChapter field in the composite key
    @JoinColumn(name = "id_chapter_book", nullable = false)
    private ChapterBook chapter;

    @ManyToOne
    @MapsId("id_book")  // Maps the idBook field in the composite key
    @JoinColumn(name = "id_book", nullable = false)
    private Book book;

    @Column(columnDefinition = "TEXT")
    private String content;

    public PageBook() {}

    public PageBook(PageRequestDTO data, ChapterBook chapter, Book book){
        this.id = new PageBookId(chapter.getId_chapter_book(), book.getId_book(), data.page_number());
        this.chapter = chapter;
        this.book = book;
        this.content = data.content();
    }

    public Integer getPageNumber() {
        return id.getPage_number();
    }
}

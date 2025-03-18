package com.example.library.library.books;

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

@Table(name = "pages")
@Entity(name = "pages")
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Page {

    @EmbeddedId
    private PageId id;

    @ManyToOne
    @MapsId("id_chapter")  // Maps the idChapter field in the composite key
    @JoinColumn(name = "id_chapter", nullable = false)
    private Chapter chapter;

    @ManyToOne
    @MapsId("id_book")  // Maps the idBook field in the composite key
    @JoinColumn(name = "id_book", nullable = false)
    private Book book;

    @Column(columnDefinition = "TEXT")
    private String content;

    public Page() {}

    public Page(Chapter chapter, Book book, Integer page_number, String content) {
        this.id = new PageId(chapter.getId_chapter(), book.getId_book(), page_number);
        this.chapter = chapter;
        this.book = book;
        this.content = content;
    }

    public Integer getPageNumber() {
        return id.getPage_number();
    }
}

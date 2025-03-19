package com.example.library.library.books;

import java.util.List;

import com.example.library.library.books.request.ChapterRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "chapters")
@Entity(name = "chapters")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_chapter")
public class Chapter {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_chapter;

    @ManyToOne
    @JoinColumn(name = "id_book", nullable = false)
    private Book book;

    private String title;
    private Integer chapter_number;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Page> pages;

    public Chapter(ChapterRequestDTO data, Book book){
        this.book = book;
        this.title = data.title();
        this.chapter_number = data.chapter_number();
    }
}
package com.example.library.library.books;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "pages")
@Entity(name = "pages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_page")
public class Page {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_page;

    @ManyToOne
    @JoinColumn(name = "id_chapter", nullable = false)
    private Chapter chapter;

    @ManyToOne
    @JoinColumn(name = "id_book", nullable = false)
    private Book book;

    private Integer page_number;

    @Column(columnDefinition = "TEXT")
    private String content;
}

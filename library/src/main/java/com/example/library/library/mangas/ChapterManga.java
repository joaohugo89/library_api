package com.example.library.library.mangas;

import java.util.List;

import com.example.library.library.mangas.request.ChapterMangaRequestDTO;

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

@Table(name = "chapters_manga")
@Entity(name = "chapters_manga")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_chapter_manga")
public class ChapterManga {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_chapter_manga;

    @ManyToOne
    @JoinColumn(name = "id_manga", nullable = false)
    private Manga manga;

    private String title;
    private Integer chapter_number;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<PageManga> pages;

    public ChapterManga(ChapterMangaRequestDTO data, Manga manga){
        this.manga = manga;
        this.title = data.title();
        this.chapter_number = data.chapter_number();
    }
}
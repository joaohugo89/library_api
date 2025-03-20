package com.example.library.library.mangas;

import com.example.library.library.mangas.request.PageMangaRequestDTO;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Table(name = "pages_manga")
@Entity(name = "pages_manga")
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class PageManga {

    @EmbeddedId
    private PageMangaId id;

    @ManyToOne
    @MapsId("id_chapter_manga")  // Maps the idChapter field in the composite key
    @JoinColumn(name = "id_chapter_manga", nullable = false)
    private ChapterManga chapter;

    @ManyToOne
    @MapsId("id_manga")  // Maps the idBook field in the composite key
    @JoinColumn(name = "id_manga", nullable = false)
    private Manga manga;

    @Lob
    private byte[] image; // Stores the image as a byte array

    public PageManga() {}
    
    public PageManga(PageMangaRequestDTO data, ChapterManga chapter, Manga manga){
        this.id = new PageMangaId(chapter.getId_chapter_manga(), manga.getId_manga(), data.page_number());
        this.chapter = chapter;
        this.manga = manga;
        this.image = data.image();
    }

    public Integer getPageNumber() {
        return id.getPage_number();
    }
}

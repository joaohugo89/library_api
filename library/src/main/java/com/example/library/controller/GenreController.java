package com.example.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.library.books.Book;
import com.example.library.library.mangas.Manga;
import com.example.library.library.books.response.BookResponseDTO;
import com.example.library.library.genres.Genre;
import com.example.library.library.genres.GroupGenreBook;
import com.example.library.library.genres.GroupGenreManga;
import com.example.library.library.genres.request.GenreRequestDTO;
import com.example.library.library.genres.request.GroupGenreBookRequestDTO;
import com.example.library.library.genres.request.GroupGenreMangaRequestDTO;
import com.example.library.library.genres.response.GenreResponseDTO;
import com.example.library.library.genres.response.GroupGenreBookResponseDTO;
import com.example.library.library.genres.response.GroupGenreMangaResponseDTO;
import com.example.library.library.mangas.response.MangaResponseDTO;
import com.example.library.repositories.BookRepository;
import com.example.library.repositories.GenreRepository;
import com.example.library.repositories.GroupGenreBookRepository;
import com.example.library.repositories.GroupGenreMangaRepository;
import com.example.library.repositories.MangaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
@RequestMapping("library")
public class GenreController {
    @Autowired
    private GenreRepository genre_repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("genres")
    public void saveGenre(@RequestBody GenreRequestDTO data){
        Genre genreData = new Genre(data);
        genre_repository.save(genreData);
        return;
    }

    @GetMapping("genres")
    public List<GenreResponseDTO> getAllGenres() {
            List<GenreResponseDTO> genreList= genre_repository.findAll().stream().map(GenreResponseDTO::new).toList();
            return genreList;
    }

    @Autowired
    private GroupGenreBookRepository groupGenreBook_repository;

    @Autowired
    private GroupGenreMangaRepository groupGenreManga_repository;

    @Autowired
    private BookRepository book_repository;

    @Autowired
    private MangaRepository manga_repository;

    //All post methods

    //Save group genre
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("group_genres_books")
    public void saveGroupGenreBook(@RequestBody GroupGenreBookRequestDTO data) {
        Book book = book_repository.findById(data.id_book())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Genre genre = genre_repository.findById(data.id_genre())
                .orElseThrow(() -> new RuntimeException("Genre not found"));

        GroupGenreBook groupGenre = new GroupGenreBook(book, genre);
        groupGenreBook_repository.save(groupGenre);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("group_genres_mangas")
    public void saveGroupGenreManga(@RequestBody GroupGenreMangaRequestDTO data) {
        Manga manga = manga_repository.findById(data.id_manga())
                .orElseThrow(() -> new RuntimeException("Manga not found"));

        Genre genre = genre_repository.findById(data.id_genre())
                .orElseThrow(() -> new RuntimeException("Genre not found"));

        GroupGenreManga groupGenre = new GroupGenreManga(manga, genre);
        groupGenreManga_repository.save(groupGenre);
    }

    //All get methods

    //Get all group genres for books
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("group_genres_books")
    public List<GroupGenreBookResponseDTO> getAllGroupGenresBooks() {
        List<GroupGenreBookResponseDTO> groupGenreList= groupGenreBook_repository.findAll().stream().map(GroupGenreBookResponseDTO::new).toList();
        return groupGenreList;
    }

    //Get all books by genre
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/books-by-genre/{genreId}")
    public List<BookResponseDTO> getBooksByGenre(@PathVariable Long genreId) {
        List<BookResponseDTO> books = groupGenreBook_repository.findBooksByGenre(genreId).stream().map(BookResponseDTO::new).toList();
        return books;
    }

    //Get all group genres for mangas
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("group_genres_mangas")
    public List<GroupGenreMangaResponseDTO> getAllGroupGenresMangas() {
        List<GroupGenreMangaResponseDTO> groupGenreList= groupGenreManga_repository.findAll().stream().map(GroupGenreMangaResponseDTO::new).toList();
        return groupGenreList;
    }

    //Get all books by genre
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/mangas-by-genre/{genreId}")
    public List<MangaResponseDTO> getMangasByGenre(@PathVariable Long genreId) {
        List<MangaResponseDTO> mangas = groupGenreManga_repository.findMangasByGenre(genreId).stream().map(MangaResponseDTO::new).toList();
        return mangas;
    }

    //All delete methods
    @DeleteMapping("genres/{id}")
    public void deleteGenre(@PathVariable Long id) {
        genre_repository.deleteById(id);
    }
}
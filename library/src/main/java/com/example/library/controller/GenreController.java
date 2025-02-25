package com.example.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.library.books.Book;
import com.example.library.library.books.response.BookResponseDTO;
import com.example.library.library.genres.Genre;
import com.example.library.library.genres.GroupGenre;
import com.example.library.library.genres.request.GenreRequestDTO;
import com.example.library.library.genres.request.GroupGenreRequestDTO;
import com.example.library.library.genres.response.GenreResponseDTO;
import com.example.library.library.genres.response.GroupGenreResponseDTO;
import com.example.library.repositories.BookRepository;
import com.example.library.repositories.GenreRepository;
import com.example.library.repositories.GroupGenreRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    private GroupGenreRepository groupGenre_repository;

    @Autowired
    private BookRepository book_repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("group_genres")
    public void saveGroupGenre(@RequestBody GroupGenreRequestDTO data) {
        Book book = book_repository.findById(data.id_book())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Genre genre = genre_repository.findById(data.id_genre())
                .orElseThrow(() -> new RuntimeException("Genre not found"));

        GroupGenre groupGenre = new GroupGenre(book, genre);
        groupGenre_repository.save(groupGenre);
    }


    @GetMapping("group_genres")
    public List<GroupGenreResponseDTO> getAllGroupGenres() {
        List<GroupGenreResponseDTO> groupGenreList= groupGenre_repository.findAll().stream().map(GroupGenreResponseDTO::new).toList();
        return groupGenreList;
    }

    @GetMapping("/books-by-genre/{genreId}")
    public List<BookResponseDTO> getBooksByGenre(@PathVariable Long genreId) {
        List<BookResponseDTO> books = groupGenre_repository.findBooksByGenre(genreId).stream().map(BookResponseDTO::new).toList();
        return books;
    }
}
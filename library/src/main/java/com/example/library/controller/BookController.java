package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.library.library.books.Book;
import com.example.library.library.books.Chapter;
import com.example.library.library.books.request.BookRequestDTO;
import com.example.library.library.books.request.BookWithChapterDTO;
import com.example.library.library.books.request.ChapterRequestDTO;
import com.example.library.library.books.response.BookResponseDTO;
import com.example.library.library.books.response.ChapterResponseDTO;
import com.example.library.library.genres.Genre;
import com.example.library.repositories.BookRepository;
import com.example.library.repositories.ChapterRepository;
import com.example.library.repositories.GroupGenreRepository;

@RestController
@CrossOrigin
@RequestMapping("library")
public class BookController {
    @Autowired
    private BookRepository book_repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("books")
    public void saveBook(@RequestBody BookRequestDTO data){
        Book bookData = new Book(data);
        book_repository.save(bookData);
        return;
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("books")
    public List<BookResponseDTO> getAllBooks() {
            List<BookResponseDTO> bookList = book_repository.findAll().stream().map(BookResponseDTO::new).toList();
            return bookList;
    }

 
    

    @Autowired
    private GroupGenreRepository groupGenre_repository;

    @GetMapping("books/{bookId}/genres/")
    public List<Genre> getGenresByBook(@PathVariable Long bookId) {
        return groupGenre_repository.findGenresByBook(bookId);
    }

    @Autowired
    private ChapterRepository chapter_repository;

    @PostMapping("books/{bookId}/chapters/")
    public void saveChapter(@RequestBody ChapterRequestDTO data, @PathVariable Long bookId) {
        // Buscar o livro no banco de dados
        Book book = book_repository.findById(bookId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));

        // Criar o capítulo com o objeto Book correto
        Chapter newChapter = new Chapter(data, book);
        chapter_repository.save(newChapter);
        return;
    }

    @GetMapping("books/chapters")
    public List<ChapterResponseDTO> getChaptersByBook() {
        List<ChapterResponseDTO> chapterList = chapter_repository.findAll().stream().map(ChapterResponseDTO::new).toList();
        return chapterList;
    }
}
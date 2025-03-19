package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.server.ResponseStatusException;

import com.example.library.library.books.Book;
import com.example.library.library.books.Chapter;
import com.example.library.library.books.Page;
import com.example.library.library.books.request.BookRequestDTO;
import com.example.library.library.books.request.ChapterRequestDTO;
import com.example.library.library.books.request.PageRequestDTO;
import com.example.library.library.books.response.BookResponseDTO;
import com.example.library.library.books.response.BookWithChaptersResponseDTO;
import com.example.library.library.books.response.ChapterResponseDTO;
import com.example.library.library.genres.Genre;

import com.example.library.repositories.BookRepository;
import com.example.library.repositories.ChapterRepository;
import com.example.library.repositories.GroupGenreRepository;
import com.example.library.repositories.PageRepository;

@RestController
@CrossOrigin
@RequestMapping("library")
public class BookController {
    @Autowired
    private BookRepository book_repository;

    @Autowired
    private ChapterRepository chapter_repository;

    @Autowired
    private GroupGenreRepository groupGenre_repository;

    @Autowired
    private PageRepository page_repository;
    
    //All Post Methods

    //Save a book
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("books")
    public void saveBook(@RequestBody BookRequestDTO data){
        Book bookData = new Book(data);
        book_repository.save(bookData);
        return;
    }
    
    //Save a chapter in a book
    @CrossOrigin(origins = "*", allowedHeaders = "*")
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

    //Save a page in a chapter of a book
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("books/{bookId}/chapters/{chapterId}/pages/")
    public void savePage(@RequestBody PageRequestDTO data, @PathVariable Long bookId, @PathVariable Long chapterId) {
        // Buscar o livro no banco de dados
        Book book = book_repository.findById(bookId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));

        // Buscar o capítulo no banco de dados
        Chapter chapter = chapter_repository.findById(chapterId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Capítulo não encontrado"));

        // Criar a página com o objeto Book e Chapter corretos
        Page newPage = new Page(data, chapter, book);
        page_repository.save(newPage);
        return;
    }

    //All Get Methods

    //Return all books, with genres and chapters(with pages)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("books")
    public List<BookResponseDTO> getAllBooks() {
        List<BookResponseDTO> bookList = book_repository.findAllOrderByIdAsc().stream().map(BookResponseDTO::new).toList();
        return bookList;
    }

    //Return all books, with chapters
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("books-with-chapters")
    public List<BookWithChaptersResponseDTO> getAllBooksWithChapters() {
        List<BookWithChaptersResponseDTO> books = book_repository.findAllWithChapters().stream().map(BookWithChaptersResponseDTO::new).toList();
        // Mapear os livros para o DTO, sem necessidade de buscar capítulos separadamente
        return books;
    }

    //Return all books, with genres
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("books/{bookId}/genres/")
    public List<Genre> getGenresByBook(@PathVariable Long bookId) {
        return groupGenre_repository.findGenresByBook(bookId);
    }

    //Return all chapters
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("books/chapters")
    public List<ChapterResponseDTO> getChaptersByBook() {
        List<ChapterResponseDTO> chapterList = chapter_repository.findAll().stream().map(ChapterResponseDTO::new).toList();
        return chapterList;
    }

    //All Delete Methods
    
    //Delete a book
    @DeleteMapping("books/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        book_repository.deleteById(bookId); //Automaticated created method by Spring
        return;
    }

    //All Put Methods

    //Update a book
    @PutMapping("books/{id}")
    public void updateBook(@RequestBody BookRequestDTO data, @PathVariable Long id) {
        Book book = book_repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));

        book.setTitle(data.title());
        book.setAutor(data.autor());
        book_repository.save(book);
        return;
    }
}
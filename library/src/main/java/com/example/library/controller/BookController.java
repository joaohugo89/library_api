package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.example.library.library.books.ChapterBook;
import com.example.library.library.books.PageBook;
import com.example.library.library.books.request.BookRequestDTO;
import com.example.library.library.books.request.ChapterBookRequestDTO;
import com.example.library.library.books.request.PageRequestDTO;
import com.example.library.library.books.response.BookResponseDTO;
import com.example.library.library.books.response.BookWithChaptersResponseDTO;
import com.example.library.library.books.response.ChapterBookResponseDTO;
import com.example.library.library.genres.Genre;

import com.example.library.repositories.BookRepository;
import com.example.library.repositories.ChapterBookRepository;
import com.example.library.repositories.GroupGenreBookRepository;
import com.example.library.repositories.PageBookRepository;

@RestController
@RequestMapping("library")
public class BookController {
    @Autowired
    private BookRepository book_repository;

    @Autowired
    private ChapterBookRepository chapter_repository;

    @Autowired
    private GroupGenreBookRepository groupGenre_repository;

    @Autowired
    private PageBookRepository page_repository;
    
    //All Post Methods

    //Save a book
    @PostMapping("books")
    public void saveBook(@RequestBody BookRequestDTO data){
        Book bookData = new Book(data);
        book_repository.save(bookData);
        return;
    }
    
    //Save a chapter in a book
    @PostMapping("books/{bookId}/chapters/")
    public void saveChapter(@RequestBody ChapterBookRequestDTO data, @PathVariable Long bookId) {
        // Buscar o livro no banco de dados
        Book book = book_repository.findById(bookId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));

        // Criar o capítulo com o objeto Book correto
        ChapterBook newChapter = new ChapterBook(data, book);
        chapter_repository.save(newChapter);
        return;
    }

    //Save a page in a chapter of a book
    @PostMapping("books/{bookId}/chapters/{chapterId}/pages/")
    public void savePage(@RequestBody PageRequestDTO data, @PathVariable Long bookId, @PathVariable Long chapterId) {
        // Buscar o livro no banco de dados
        Book book = book_repository.findById(bookId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));

        // Buscar o capítulo no banco de dados
        ChapterBook chapter = chapter_repository.findById(chapterId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Capítulo não encontrado"));

        // Criar a página com o objeto Book e Chapter corretos
        PageBook newPage = new PageBook(data, chapter, book);
        page_repository.save(newPage);
        return;
    }

    //All Get Methods

    //Return all books, with genres and chapters(with pages)
    @GetMapping("books")
    public List<BookResponseDTO> getAllBooks() {
        List<BookResponseDTO> bookList = book_repository.findAllOrderByIdAsc().stream().map(BookResponseDTO::new).toList();
        return bookList;
    }

    //Return all books, with chapters
    @GetMapping("books-with-chapters")
    public List<BookWithChaptersResponseDTO> getAllBooksWithChapters() {
        List<BookWithChaptersResponseDTO> books = book_repository.findAllWithChapters().stream().map(BookWithChaptersResponseDTO::new).toList();
        // Mapear os livros para o DTO, sem necessidade de buscar capítulos separadamente
        return books;
    }

    //Return all books, with genres
    @GetMapping("books/{bookId}/genres/")
    public List<Genre> getGenresByBook(@PathVariable Long bookId) {
        return groupGenre_repository.findGenresByBook(bookId);
    }

    //Return all chapters
    @GetMapping("books/chapters")
    public List<ChapterBookResponseDTO> getChaptersByBook() {
        List<ChapterBookResponseDTO> chapterList = chapter_repository.findAll().stream().map(ChapterBookResponseDTO::new).toList();
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
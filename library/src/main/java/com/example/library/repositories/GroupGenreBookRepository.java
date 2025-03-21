package com.example.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.library.library.books.Book;
import com.example.library.library.genres.Genre;
import com.example.library.library.genres.GroupGenreBook;
import com.example.library.library.genres.GroupGenreBookId;

public interface GroupGenreBookRepository extends JpaRepository<GroupGenreBook, GroupGenreBookId>{
    @Query("SELECT g.book FROM group_genres_book g WHERE g.genre.id = :genreId")
    List<Book> findBooksByGenre(@Param("genreId") Long genreId);

    @Query("SELECT g.genre FROM group_genres_book g WHERE g.book.id = :bookId")
    List<Genre> findGenresByBook(@Param("bookId") Long bookId);
}

package com.example.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.library.books.Page;
import com.example.library.library.books.PageId;

public interface PageRepository extends JpaRepository<Page, PageId>{
}

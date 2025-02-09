package com.example.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.library.books.Page;

public interface PageRepository extends JpaRepository<Page, Long>{
    
}

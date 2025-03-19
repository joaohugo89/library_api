package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.library.mangas.Manga;
import com.example.library.library.mangas.request.MangaRequestDTO;
import com.example.library.library.mangas.response.MangaResponseDTO;
import com.example.library.repositories.MangaRepository;

@RestController
@CrossOrigin
@RequestMapping("library")
public class MangaController {
    @Autowired
    private MangaRepository manga_repository;
    
    //All post methods

    //Save manga
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("mangas")
    public void saveManga(@RequestBody MangaRequestDTO data){
        Manga mangaData = new Manga(data);
        manga_repository.save(mangaData);
        return;
    }

    //All get methods

    //Get all mangas
    @GetMapping("mangas")
    public List<MangaResponseDTO> getAllMangas() {
            List<MangaResponseDTO> mangaList= manga_repository.findAll().stream().map(MangaResponseDTO::new).toList();
            return mangaList;
    }

    //All delete methods

    //Delete manga
    @DeleteMapping("mangas/{mangaId}")
    public void deleteManga(@PathVariable Long mangaId) {
        manga_repository.deleteById(mangaId);
        return;
    }
}

package com.example.library.library.genres;

import com.example.library.library.genres.request.GenreRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "genres")
@Entity(name = "genres")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_genre")
public class Genre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_genre;
    private String name;

    public Genre(GenreRequestDTO data){
        this.name = data.name();
    }
}
package com.example.library.library.mangas;

import java.util.Set;

import com.example.library.library.genres.GroupGenreManga;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "mangas")
@Entity(name = "mangas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_manga")
public class Manga {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_manga;
    private String title;
    private String autor;

    @OneToMany(mappedBy = "manga", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<GroupGenreManga> groupGenresManga;

}

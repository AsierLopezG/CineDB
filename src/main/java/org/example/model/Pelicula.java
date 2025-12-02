package org.example.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "peliculas")

public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Integer idPelicula;

    @Column(name = "titulo")
    private String titulo;


    @Column(name = "duracion_minutos")
    private Integer duracionMin;

    @Column(name = "genero")
    private String genero;

    @Column(name = "clasificacion")
    private String clasificacion;

    @Column(name = "director")
    private String director;

    @Column(name = "sinopsis")
    private String sinopsis;

    @Column(name = "fecha_estreno")
    private LocalDate fechaEstreno;

    @Column(name = "popularidad")
    private Integer popularidad;

    @Column(name = "activa")
    private Boolean activa ;

    @Column(name = "fecha_baja")
    private LocalDate fechaBaja;

}

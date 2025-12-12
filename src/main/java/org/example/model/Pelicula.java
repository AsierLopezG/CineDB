package org.example.model;

import jakarta.persistence.*;
import java.math.BigDecimal; // Para popularidad
import java.time.LocalDate;  // Para fechas

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
    private Integer duracionMinutos;

    @Column(name = "genero")
    private String genero;

    @Column(name = "clasificacion")
    private String clasificacion;

    @Column(name = "director")
    private String director;

    @Column(name = "sinopsis") // Campo largo
    private String sinopsis;

    @Column(name = "fecha_estreno")
    private LocalDate fechaEstreno;

    @Column(name = "popularidad") // Puede ser decimal (ej: 4.5 estrellas)
    private BigDecimal popularidad;

    @Column(name = "activa")
    private Boolean activa;

    @Column(name = "fecha_baja") // Puede ser nulo si sigue activa
    private LocalDate fechaBaja;

    // --- CONSTRUCTOR VACÍO ---
    public Pelicula() {
    }

    // --- GETTERS Y SETTERS ---
    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public BigDecimal getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(BigDecimal popularidad) {
        this.popularidad = popularidad;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
}
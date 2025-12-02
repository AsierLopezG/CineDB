package org.example.controller;

import org.example.model.Pelicula;
import org.example.service.PeliculaService;
import org.example.service.ProyeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> listar() {
        return peliculaService.lisatarTodas();
    }

    @GetMapping("/{id}")
    public Pelicula obtenerUno(@PathVariable Integer id) {
        return peliculaService.obtenerPorID(id);
    }

    @PostMapping
    public Pelicula guardar(@RequestBody Pelicula pelicula) {
        return peliculaService.guardar(pelicula);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        peliculaService.eliminar(id);
    }

}

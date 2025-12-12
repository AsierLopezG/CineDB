package org.example.controller;

import org.example.model.Pelicula;
import org.example.service.PeliculaService;
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
        return peliculaService.listarTodas();
    }

    @PostMapping
    public Pelicula guardar(@RequestBody Pelicula pelicula) {
        return peliculaService.guardar(pelicula);
    }

    @GetMapping("/{id}")
    public Pelicula obtenerUna(@PathVariable Integer id) {
        return peliculaService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        peliculaService.eliminar(id);
    }
}

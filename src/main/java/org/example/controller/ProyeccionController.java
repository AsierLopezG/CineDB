package org.example.controller;

import org.example.model.Proyeccion;
import org.example.service.ProyeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/proyecciones")
public class ProyeccionController {

    @Autowired
    private ProyeccionService proyeccionService;

    @GetMapping
    public List<Proyeccion> listar() {
        return proyeccionService.listarTodas();
    }

    @GetMapping("/{id}")
    public Proyeccion obtenerUno(@PathVariable Integer id) {
        return proyeccionService.obtenerPorId(id);
    }

    @PostMapping
    public Proyeccion guardar(@RequestBody Proyeccion proyeccion) {
        return proyeccionService.guardar(proyeccion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        proyeccionService.eliminar(id);
    }
}

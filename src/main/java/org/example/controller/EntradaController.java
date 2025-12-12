package org.example.controller;

import org.example.model.Entrada;
import org.example.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/entradas")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @GetMapping
    public List<Entrada> listar() {
        return entradaService.listarTodas();
    }

    @PostMapping
    public Entrada venderEntrada(@RequestBody Entrada entrada) {
        return entradaService.guardar(entrada);
    }

    @GetMapping("/{id}")
    public Entrada obtenerUna(@PathVariable Integer id) {
        return entradaService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        entradaService.eliminar(id);
    }
}
package org.example.service;

import org.example.model.Pelicula;
import org.example.model.Proyeccion;
import org.example.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.PrimitiveIterator;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> lisatarTodas() {
        return peliculaRepository.findAll();
    }

    public Pelicula guardar(Pelicula pelicula){
        return  peliculaRepository.save(pelicula);
    }

    public Pelicula obtenerPorID(Integer id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        peliculaRepository.deleteById(id);
    }



}

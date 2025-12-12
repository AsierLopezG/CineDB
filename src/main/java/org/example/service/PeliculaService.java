package org.example.service;

import org.example.model.Pelicula;
import org.example.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> listarTodas() {
        return peliculaRepository.findAll();
    }

    public Pelicula guardar(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public Pelicula obtenerPorId(Integer id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        peliculaRepository.deleteById(id);
    }
}
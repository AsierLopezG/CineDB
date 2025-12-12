package org.example.service;

import org.example.model.Proyeccion;
import org.example.repository.ProyeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProyeccionService {

    @Autowired
    private ProyeccionRepository proyeccionRepository;

    public List<Proyeccion> listarTodas() {
        return proyeccionRepository.findAll();
    }

    public Proyeccion guardar(Proyeccion proyeccion) {
        return proyeccionRepository.save(proyeccion);
    }

    public Proyeccion obtenerPorId(Integer id) {
        return proyeccionRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        proyeccionRepository.deleteById(id);
    }
}

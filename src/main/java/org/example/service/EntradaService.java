package org.example.service;

import org.example.model.Entrada;
import org.example.model.Proyeccion;
import org.example.repository.EntradaRepository;
import org.example.repository.ProyeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private ProyeccionRepository proyeccionRepository;


    public List<Entrada> listarTodas() {
        return entradaRepository.findAll();
    }


    public Entrada guardar(Entrada entrada) {

        Proyeccion proyeccion = proyeccionRepository.findById(entrada.getIdProyeccion()).orElseThrow(() -> new RuntimeException("Error: La proyección no existe"));
        if (proyeccion.getAsientosDisponibles() <= 0) {
            throw new RuntimeException("Error: ¡La sala está llena!");
        }
        proyeccion.setAsientosDisponibles(proyeccion.getAsientosDisponibles() - 1);
        proyeccionRepository.save(proyeccion);

        if (entrada.getFechaVenta() == null) {
            entrada.setFechaVenta(LocalDateTime.now());
        }
        return entradaRepository.save(entrada);
    }


    public Entrada obtenerPorId(Integer id) {
        return entradaRepository.findById(id).orElse(null);
    }


    public void eliminar(Integer id) {
        entradaRepository.deleteById(id);
    }
}
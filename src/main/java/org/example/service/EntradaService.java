package org.example.service;

import org.example.model.Entrada;
import org.example.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    public List<Entrada> listarTodas() {
        return entradaRepository.findAll();
    }

    public Entrada guardar(Entrada entrada) {

        return entradaRepository.save(entrada);
    }

    public Entrada obtenerPorId(Integer id) {
        return entradaRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        entradaRepository.deleteById(id);
    }
}

package org.example.service;

import org.example.model.Empleado;
import org.example.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // 1. GUARDAR O ACTUALIZAR
    // Si el empleado NO tiene ID, lo CREA.
    // Si el empleado SÍ tiene ID, lo ACTUALIZA.
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    // 2. LISTAR TODOS
    public List<Empleado> listarTodos() {
        return empleadoRepository.findAll();
    }

    // 3. BUSCAR POR ID (NUEVO)
    public Empleado obtenerPorId(Integer id) {
        // Buscamos por ID, si no existe devolvemos null
        return empleadoRepository.findById(id).orElse(null);
    }

    // 4. BORRAR (NUEVO)
    public void eliminarEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
}

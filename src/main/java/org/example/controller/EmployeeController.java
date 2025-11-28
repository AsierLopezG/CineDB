package org.example.controller;

import org.example.model.Empleado;
import org.example.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmpleadoService empleadoService;

    // GUARDAR O ACTUALIZAR (POST)
    @PostMapping
    public Empleado guardar(@RequestBody Empleado empleado) {
        return empleadoService.guardarEmpleado(empleado);
    }

    // LISTAR TODOS (GET)
    @GetMapping
    public List<Empleado> listar() {
        return empleadoService.listarTodos();
    }

    // BUSCAR UNO POR ID (GET con parámetro) -> NUEVO
    // URL ejemplo: http://localhost:8080/api/empleados/1
    @GetMapping("/{id}")
    public Empleado obtenerUno(@PathVariable Integer id) {
        return empleadoService.obtenerPorId(id);
    }

    // BORRAR POR ID (DELETE) -> NUEVO
    // URL ejemplo: http://localhost:8080/api/empleados/1
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        empleadoService.eliminarEmpleado(id);
    }
}
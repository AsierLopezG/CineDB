package org.example.controller;

import org.example.model.Empleado;
import org.example.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public Empleado insertar(@RequestBody Empleado empleado) {
        return empleadoService.guardarEmpleado(empleado);
    }
}
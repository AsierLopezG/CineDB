package org.example.controller;

import org.example.model.Empleado;
import org.example.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employee") // Tu ruta base
public class EmployeeController {

    @Autowired
    private EmpleadoService empleadoService;

    // 1. GUARDAR O ACTUALIZAR (POST)
    // Al ejecutar esto, el Service guardará en SQL y también en Mongo automáticamente
    @PostMapping
    public Empleado guardar(@RequestBody Empleado empleado) {
        return empleadoService.guardarEmpleado(empleado);
    }

    // 2. LISTAR TODOS (GET)
    @GetMapping
    public List<Empleado> listar() {
        return empleadoService.listarTodos();
    }

    // 3. BUSCAR UNO POR ID
    @GetMapping("/{id}")
    public Empleado obtenerUno(@PathVariable Integer id) {
        return empleadoService.obtenerPorId(id);
    }

    // 4. BORRAR POR ID (DELETE)
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        empleadoService.eliminarEmpleado(id);
    }

    // --- NUEVO ENDPOINT PARA EL EJERCICIO 2 ---
    // 5. SINCRONIZAR DATOS ANTIGUOS
    // Este es el botón que tienes que pulsar para pasar los datos viejos a Mongo
    @PostMapping("/sync")
    public String sincronizarMongo() {
        empleadoService.sincronizarBaseDeDatos();
        return "¡Sincronización lanzada! Revisa tu MongoDB Compass.";
    }
}
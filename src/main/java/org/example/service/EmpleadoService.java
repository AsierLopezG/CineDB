package org.example.service;

import org.example.model.Empleado;
import org.example.model.EmpleadoMongo;
import org.example.repository.EmpleadoRepository;
import org.example.repository.EmpleadoMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository; // Repositorio SQL (PostgreSQL)

    @Autowired
    private EmpleadoMongoRepository empleadoMongoRepository; // Repositorio MongoDB

    // Método auxiliar para convertir de Entidad SQL a Documento Mongo
    private EmpleadoMongo mapearAMongo(Empleado empleadoSql) {
        EmpleadoMongo doc = new EmpleadoMongo();

        // Si quieres mantener el mismo ID numérico de SQL en Mongo para identificarlos fácil:
        // doc.setId(String.valueOf(empleadoSql.getIdEmpleado()));
        // Si prefieres que Mongo genere su propio ID aleatorio, no setees el ID (deja que sea null)

        doc.setIdEmpleado(empleadoSql.getIdEmpleado()); // Guardamos el ID de SQL como un campo más
        doc.setNombre(empleadoSql.getNombre());
        doc.setPuesto(empleadoSql.getPuesto());
        doc.setTipoJornada(empleadoSql.getTipoJornada());
        doc.setEmail(empleadoSql.getEmail());
        doc.setTelefono(empleadoSql.getTelefono());
        doc.setFechaContratacion(empleadoSql.getFechaContratacion());
        doc.setSalarioHora(empleadoSql.getSalarioHora());
        doc.setActivo(empleadoSql.getActivo());

        return doc;
    }

    // 1. GUARDAR O ACTUALIZAR (DOBLE ESCRITURA)
    public Empleado guardarEmpleado(Empleado empleado) {

        // A) Guardamos en PostgreSQL primero (La fuente principal)
        Empleado empleadoGuardado = empleadoRepository.save(empleado);

        // B) Lógica para insertar también en MongoDB
        try {
            EmpleadoMongo empleadoMongo = mapearAMongo(empleadoGuardado);
            empleadoMongoRepository.save(empleadoMongo);
            System.out.println("--> Empleado replicado en MongoDB: " + empleadoGuardado.getNombre());
        } catch (Exception e) {
            System.err.println("Error al guardar en MongoDB: " + e.getMessage());
        }

        return empleadoGuardado;
    }

    // 2. LISTAR TODOS (De SQL)
    public List<Empleado> listarTodos() {
        return empleadoRepository.findAll();
    }

    // 3. BUSCAR POR ID
    public Empleado obtenerPorId(Integer id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    // 4. BORRAR (Opcional: borrar de ambos sitios)
    public void eliminarEmpleado(Integer id) {
        // Borrar de SQL
        empleadoRepository.deleteById(id);

        // Borrar de Mongo (buscando por el campo idEmpleado que guardamos)
        // empleadoMongoRepository.deleteByIdEmpleado(id); // Necesitarías crear este método en el repo
    }

    // 5. MÉTODO DE MIGRACIÓN (Para el botón de sincronizar)
    public void sincronizarBaseDeDatos() {
        List<Empleado> todosSql = empleadoRepository.findAll();
        for (Empleado emp : todosSql) {
            try {
                EmpleadoMongo doc = mapearAMongo(emp);
                empleadoMongoRepository.save(doc);
            } catch (Exception e) {
                System.err.println("Error migrando empleado " + emp.getIdEmpleado());
            }
        }
        System.out.println("Migración completa: " + todosSql.size() + " empleados movidos a Mongo.");
    }
}
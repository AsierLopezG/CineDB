package org.example.repository;

import org.example.model.Proyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyeccionRepository extends JpaRepository<Proyeccion, Integer> {
}
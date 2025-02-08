package com.itsqmet.tiendaEvaluacion.Repositorio;

import com.itsqmet.tiendaEvaluacion.Entidad.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepositorio extends JpaRepository<Proyecto, Long> {
    // Otros métodos si son necesarios
}
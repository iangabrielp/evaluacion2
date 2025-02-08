package com.itsqmet.tiendaEvaluacion.Repositorio;

import com.itsqmet.tiendaEvaluacion.Entidad.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepositorio extends JpaRepository<Tarea, Long> {
    // Otros métodos si son necesarios
}

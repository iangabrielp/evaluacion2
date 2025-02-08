package com.itsqmet.tiendaEvaluacion.Repositorio;

import com.itsqmet.tiendaEvaluacion.Entidad.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepositorio extends JpaRepository<Tecnico, Long> {
    // Otros métodos si son necesarios
}

package com.itsqmet.tiendaEvaluacion.Servicio;

import com.itsqmet.tiendaEvaluacion.Entidad.Tarea;
import com.itsqmet.tiendaEvaluacion.Repositorio.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServicio {
    @Autowired
    private TareaRepositorio tareaRepositorio;

    public List<Tarea> listarTareas() {
        return tareaRepositorio.findAll();
    }

    public Tarea obtenerTareaPorId(Long id) {
        return tareaRepositorio.findById(id).orElse(null);
    }

    public void guardarTarea(Tarea tarea) {
        tareaRepositorio.save(tarea);
    }

    public void eliminarTarea(Long id) {
        tareaRepositorio.deleteById(id);
    }
}

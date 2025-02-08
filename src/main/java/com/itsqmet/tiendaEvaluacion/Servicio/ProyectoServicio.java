package com.itsqmet.tiendaEvaluacion.Servicio;

import com.itsqmet.tiendaEvaluacion.Entidad.Proyecto;
import com.itsqmet.tiendaEvaluacion.Repositorio.ProyectoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoServicio {
    @Autowired
    private ProyectoRepositorio proyectoRepositorio;

    public List<Proyecto> listarProyectos() {
        return proyectoRepositorio.findAll();
    }

    public Proyecto obtenerProyectoPorId(Long id) {
        return proyectoRepositorio.findById(id).orElse(null);
    }

    public void guardarProyecto(Proyecto proyecto) {
        proyectoRepositorio.save(proyecto);
    }

    public void eliminarProyecto(Long id) {
        proyectoRepositorio.deleteById(id);
    }
}

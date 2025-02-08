package com.itsqmet.tiendaEvaluacion.Servicio;

import com.itsqmet.tiendaEvaluacion.Entidad.Tecnico;
import com.itsqmet.tiendaEvaluacion.Repositorio.TecnicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoServicio {
    @Autowired
    private TecnicoRepositorio tecnicoRepositorio;

    public List<Tecnico> listarTecnicos() {
        return tecnicoRepositorio.findAll();
    }

    public Tecnico obtenerTecnicoPorId(Long id) {
        return tecnicoRepositorio.findById(id).orElse(null);
    }

    public void guardarTecnico(Tecnico tecnico) {
        tecnicoRepositorio.save(tecnico);
    }

    public void eliminarTecnico(Long id) {
        tecnicoRepositorio.deleteById(id);
    }
}

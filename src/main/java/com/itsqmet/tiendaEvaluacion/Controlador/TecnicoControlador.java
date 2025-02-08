package com.itsqmet.tiendaEvaluacion.Controlador;

import com.itsqmet.tiendaEvaluacion.Entidad.Tecnico;
import com.itsqmet.tiendaEvaluacion.Servicio.TecnicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tecnicos")
public class TecnicoControlador {

    @Autowired
    private TecnicoServicio tecnicoServicio;

    @GetMapping("/registro")
    public String mostrarFormularioRegistroTecnico(Model model) {
        model.addAttribute("tecnico", new Tecnico());
        return "Formularios/Tecnico";
    }

    @PostMapping("/guardar")
    public String guardarTecnico(@ModelAttribute Tecnico tecnico) {
        tecnicoServicio.guardarTecnico(tecnico);
        return "redirect:/Listas/Tecnico"; // Redirige a la lista después de guardar
    }

    @GetMapping("/lista")
    public String listarTecnicos(Model model) {
        model.addAttribute("tecnicos", tecnicoServicio.listarTecnicos());
        return "Listas/Tecnico";
    }

    // Métodos para editar y eliminar técnicos
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarTecnico(@PathVariable Long id, Model model) {
        Tecnico tecnico = tecnicoServicio.obtenerTecnicoPorId(id);
        model.addAttribute("tecnico", tecnico);
        return "Formularios/Tecnico"; // Reutiliza el formulario de registro
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTecnico(@PathVariable Long id) {
        tecnicoServicio.eliminarTecnico(id);
        return "redirect:/Listas/Tecnico"; // Redirige a la lista después de eliminar
    }
}

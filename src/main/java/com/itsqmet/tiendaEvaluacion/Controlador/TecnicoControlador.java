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
        return "tecnico/formulario";
    }

    @PostMapping("/guardar")
    public String guardarTecnico(@ModelAttribute Tecnico tecnico) {
        tecnicoServicio.guardarTecnico(tecnico);
        return "redirect:/tecnicos/lista"; // Redirige a la lista después de guardar
    }

    @GetMapping("/lista")
    public String listarTecnicos(Model model) {
        model.addAttribute("tecnicos", tecnicoServicio.listarTecnicos());
        return "tecnico/lista";
    }

    // Métodos para editar y eliminar técnicos
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarTecnico(@PathVariable Long id, Model model) {
        Tecnico tecnico = tecnicoServicio.obtenerTecnicoPorId(id);
        model.addAttribute("tecnico", tecnico);
        return "tecnico/formulario"; // Reutiliza el formulario de registro
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTecnico(@PathVariable Long id) {
        tecnicoServicio.eliminarTecnico(id);
        return "redirect:/tecnicos/lista"; // Redirige a la lista después de eliminar
    }
}

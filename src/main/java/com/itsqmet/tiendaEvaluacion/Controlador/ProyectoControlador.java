package com.itsqmet.tiendaEvaluacion.Controlador;

import com.itsqmet.tiendaEvaluacion.Entidad.Proyecto;
import com.itsqmet.tiendaEvaluacion.Servicio.ProyectoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proyectos")
public class ProyectoControlador {

    @Autowired
    private ProyectoServicio proyectoServicio;

    @GetMapping("/registro")
    public String mostrarFormularioRegistroProyecto(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        return "Formularios/Proyecto";
    }

    @PostMapping("/guardar")
    public String guardarProyecto(@ModelAttribute Proyecto proyecto) {
        proyectoServicio.guardarProyecto(proyecto);
        return "redirect:/Listas/Proyecto"; // Redirige a la lista después de guardar
    }

    @GetMapping("/lista")
    public String listarProyectos(Model model) {
        model.addAttribute("proyectos", proyectoServicio.listarProyectos());
        return "Listas/Proyecto";
    }

    // Métodos para editar y eliminar proyectos
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarProyecto(@PathVariable Long id, Model model) {
        Proyecto proyecto = proyectoServicio.obtenerProyectoPorId(id);
        model.addAttribute("proyecto", proyecto);
        return "Formularios/Proyecto"; // Reutiliza el formulario de registro
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProyecto(@PathVariable Long id) {
        proyectoServicio.eliminarProyecto(id);
        return "redirect:/Listas/Proyecto"; // Redirige a la lista después de eliminar
    }
}
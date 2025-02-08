package com.itsqmet.tiendaEvaluacion.Controlador;

import com.itsqmet.tiendaEvaluacion.Entidad.Tarea;
import com.itsqmet.tiendaEvaluacion.Servicio.ProyectoServicio;
import com.itsqmet.tiendaEvaluacion.Servicio.TareaServicio;
import com.itsqmet.tiendaEvaluacion.Servicio.TecnicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tareas")
public class TareaControlador {

    @Autowired
    private TareaServicio tareaServicio;

    @Autowired
    private TecnicoServicio tecnicoServicio;

    @Autowired
    private ProyectoServicio proyectoServicio;

    @GetMapping("/registro")
    public String mostrarFormularioRegistroTarea(Model model) {
        model.addAttribute("tarea", new Tarea());
        model.addAttribute("tecnicos", tecnicoServicio.listarTecnicos());
        model.addAttribute("proyectos", proyectoServicio.listarProyectos());
        return "tarea/formulario";
    }

    @PostMapping("/guardar")
    public String guardarTarea(@ModelAttribute Tarea tarea) {
        tareaServicio.guardarTarea(tarea);
        return "redirect:/tareas/lista"; // Redirige a la lista después de guardar
    }

    @GetMapping("/lista")
    public String listarTareas(Model model) {
        model.addAttribute("tareas", tareaServicio.listarTareas());
        return "tarea/lista";
    }

    // Métodos para editar y eliminar tareas
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarTarea(@PathVariable Long id, Model model) {
        Tarea tarea = tareaServicio.obtenerTareaPorId(id);
        model.addAttribute("tarea", tarea);
        model.addAttribute("tecnicos", tecnicoServicio.listarTecnicos());
        model.addAttribute("proyectos", proyectoServicio.listarProyectos());
        return "tarea/formulario"; // Reutiliza el formulario de registro
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTarea(@PathVariable Long id) {
        tareaServicio.eliminarTarea(id);
        return "redirect:/tareas/lista"; // Redirige a la lista después de eliminar
    }
}
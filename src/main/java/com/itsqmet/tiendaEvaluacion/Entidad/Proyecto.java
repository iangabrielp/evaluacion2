package com.itsqmet.tiendaEvaluacion.Entidad;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Proyecto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(length = 45)
        private String nombre;

        @Column
        private String descripcion;

        @Column
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date fechaInicio;

        @Column
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date fechaFin;

        @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY)
        private List<Tarea> tareas = new ArrayList<>();

        // Getters y setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public Date getFechaInicio() {
            return fechaInicio;
        }

        public void setFechaInicio(Date fechaInicio) {
            this.fechaInicio = fechaInicio;
        }

        public Date getFechaFin() {
            return fechaFin;
        }

        public void setFechaFin(Date fechaFin) {
            this.fechaFin = fechaFin;
        }

        public List<Tarea> getTareas() {
            return tareas;
        }

        public void setTareas(List<Tarea> tareas) {
            this.tareas = tareas;
        }

}
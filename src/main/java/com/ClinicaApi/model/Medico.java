package com.ClinicaApi.model;

import jakarta.persistence.*;

@Entity // Indica que esta clase es una entidad JPA
@Table(name = "medicos") // Especifica el nombre de la tabla en la base de datos
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único del médico

    @Column(name = "nombre") // Columna que almacena el nombre del médico
    private String nombre; // Nombre del médico

    @Column(name = "especialidad") // Columna que almacena la especialidad del médico
    private String especialidad; // Especialidad del médico

    // Getters y setters para los campos de la clase

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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Método toString para imprimir información sobre el médico
    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}

package com.ClinicaApi.model;

import jakarta.persistence.*;

@Entity // Indica que esta clase es una entidad JPA, mapeada a una tabla en la base de datos
@Table(name = "pacientes") // Especifica el nombre de la tabla en la base de datos donde se almacenarán los registros de Paciente
public class Paciente {
    @Id // Indica que este campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de valores para la clave primaria (autoincremental en MySQL)
    private Long id;

    @Column(name = "nombre") // Especifica el nombre de la columna en la tabla de la base de datos
    private String nombre;

    @Column(name = "apellido") // Especifica el nombre de la columna en la tabla de la base de datos
    private String apellido;

    @Column(name = "dni") // Especifica el nombre de la columna en la tabla de la base de datos
    private String dni;

    // Getters y Setters para todos los campos de la clase

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Método toString() para representar el objeto Paciente como una cadena
    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}

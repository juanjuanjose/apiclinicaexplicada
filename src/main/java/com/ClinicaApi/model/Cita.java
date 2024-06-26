package com.ClinicaApi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Indica que esta clase es una entidad JPA
@Table(name = "citas") // Especifica el nombre de la tabla en la base de datos
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único de la cita

    @ManyToOne // Relación muchos a uno con la entidad Paciente
    @JoinColumn(name = "paciente_id") // Nombre de la columna que hace referencia al paciente
    private Paciente paciente; // Paciente asociado a la cita

    @ManyToOne // Relación muchos a uno con la entidad Medico
    @JoinColumn(name = "medico_id") // Nombre de la columna que hace referencia al médico
    private Medico medico; // Médico asociado a la cita

    @Column(name = "fecha") // Columna que almacena la fecha y hora de la cita
    private LocalDateTime fecha; // Fecha y hora de la cita

    // Getters y setters para los campos de la clase

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    // Método toString para imprimir información sobre la cita
    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", fecha=" + fecha +
                '}';
    }
}

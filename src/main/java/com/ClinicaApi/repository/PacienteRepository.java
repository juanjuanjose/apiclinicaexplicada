package com.ClinicaApi.repository;

import com.ClinicaApi.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository // Indica que esta interfaz es un componente de repositorio gestionado por Spring
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findByNombreContaining(String nombre); // Método para buscar pacientes por nombre que contiene cierto texto
}

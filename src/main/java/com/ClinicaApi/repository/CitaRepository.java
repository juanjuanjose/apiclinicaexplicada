package com.ClinicaApi.repository;

import com.ClinicaApi.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indica que esta interfaz es un componente de repositorio gestionado por Spring
public interface CitaRepository extends JpaRepository<Cita, Long> {
    void deleteByPacienteId(Long id); // Método personalizado para eliminar citas por el ID del paciente
}

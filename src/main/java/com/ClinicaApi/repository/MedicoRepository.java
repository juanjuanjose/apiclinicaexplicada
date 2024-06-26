package com.ClinicaApi.repository;

import com.ClinicaApi.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository // Indica que esta interfaz es un componente de repositorio gestionado por Spring
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    List<Medico> findByNombreContaining(String nombre); // Método para buscar médicos por nombre que contiene cierto texto
}

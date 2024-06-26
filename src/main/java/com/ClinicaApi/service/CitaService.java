package com.ClinicaApi.service;

import com.ClinicaApi.model.Cita;
import com.ClinicaApi.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indica que esta clase es un componente de servicio gestionado por Spring
public class CitaService {
    @Autowired
    private CitaRepository citaRepository; // Inyección de dependencia del repositorio CitaRepository

    // Método para guardar una cita
    public Cita save(Cita cita) {
        return citaRepository.save(cita); // Utiliza el método save del repositorio para guardar la cita en la base de datos
    }

    // Método para obtener todas las citas
    public List<Cita> findAll() {
        return citaRepository.findAll(); // Utiliza el método findAll del repositorio para obtener todas las citas de la base de datos
    }

    // Método para buscar una cita por su ID
    public Optional<Cita> findById(Long id) {
        return citaRepository.findById(id); // Utiliza el método findById del repositorio para buscar una cita por su ID en la base de datos
    }

    // Método para eliminar una cita por su ID
    public void deleteById(Long id) {
        citaRepository.deleteById(id); // Utiliza el método deleteById del repositorio para eliminar una cita por su ID de la base de datos
    }

    // Método para eliminar todas las citas
    public void deleteAll() {
        citaRepository.deleteAll(); // Utiliza el método deleteAll del repositorio para eliminar todas las citas de la base de datos
    }
}

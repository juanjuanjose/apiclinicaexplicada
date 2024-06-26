package com.ClinicaApi.service;

import com.ClinicaApi.model.Paciente;
import com.ClinicaApi.repository.CitaRepository;
import com.ClinicaApi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service // Indica que esta clase es un componente de servicio gestionado por Spring
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository; // Inyección de dependencia del repositorio PacienteRepository

    @Autowired
    private CitaRepository citaRepository; // Inyección de dependencia del repositorio CitaRepository

    // Método para guardar un paciente
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente); // Utiliza el método save del repositorio para guardar el paciente en la base de datos
    }

    // Método para obtener todos los pacientes
    public List<Paciente> findAll() {
        return pacienteRepository.findAll(); // Utiliza el método findAll del repositorio para obtener todos los pacientes de la base de datos
    }

    // Método para buscar un paciente por su ID
    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id); // Utiliza el método findById del repositorio para buscar un paciente por su ID en la base de datos
    }

    // Método para eliminar un paciente por su ID
    public void deleteById(Long id) {
        pacienteRepository.deleteById(id); // Utiliza el método deleteById del repositorio para eliminar un paciente por su ID de la base de datos
    }

    // Método para eliminar todos los pacientes
    @Transactional // Se utiliza transacción para asegurar la consistencia de la base de datos
    public void deleteAll() {
        List<Paciente> pacientes = pacienteRepository.findAll(); // Obtener todos los pacientes de la base de datos

        for (Paciente paciente : pacientes) {
            citaRepository.deleteByPacienteId(paciente.getId()); // Eliminar todas las citas asociadas a cada paciente
        }

        pacienteRepository.deleteAll(); // Eliminar todos los pacientes de la base de datos
    }

    // Método para buscar pacientes cuyo nombre contiene cierto texto
    public List<Paciente> findByNombreContaining(String nombre) {
        return pacienteRepository.findByNombreContaining(nombre); // Utiliza el método findByNombreContaining del repositorio para buscar pacientes cuyo nombre contiene cierto texto en la base de datos
    }
}

package com.ClinicaApi.service;

import com.ClinicaApi.model.Medico;
import com.ClinicaApi.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indica que esta clase es un componente de servicio gestionado por Spring
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository; // Inyección de dependencia del repositorio MedicoRepository

    // Método para guardar un médico
    public Medico save(Medico medico) {
        return medicoRepository.save(medico); // Utiliza el método save del repositorio para guardar el médico en la base de datos
    }

    // Método para obtener todos los médicos
    public List<Medico> findAll() {
        return medicoRepository.findAll(); // Utiliza el método findAll del repositorio para obtener todos los médicos de la base de datos
    }

    // Método para buscar un médico por su ID
    public Optional<Medico> findById(Long id) {
        return medicoRepository.findById(id); // Utiliza el método findById del repositorio para buscar un médico por su ID en la base de datos
    }

    // Método para eliminar un médico por su ID
    public void deleteById(Long id) {
        medicoRepository.deleteById(id); // Utiliza el método deleteById del repositorio para eliminar un médico por su ID de la base de datos
    }

    // Método para eliminar todos los médicos
    public void deleteAll() {
        medicoRepository.deleteAll(); // Utiliza el método deleteAll del repositorio para eliminar todos los médicos de la base de datos
    }

    // Método para buscar médicos cuyo nombre contiene cierto texto
    public List<Medico> findByNombreContaining(String nombre) {
        return medicoRepository.findByNombreContaining(nombre); // Utiliza el método findByNombreContaining del repositorio para buscar médicos cuyo nombre contiene cierto texto en la base de datos
    }
}

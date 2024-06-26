package com.ClinicaApi.controller;

import com.ClinicaApi.model.Paciente;
import com.ClinicaApi.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService; // Inyección de dependencia del servicio PacienteService

    // Endpoint para crear un nuevo paciente mediante una solicitud POST
    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        Paciente savedPaciente = pacienteService.save(paciente); // Guardar el paciente utilizando el servicio PacienteService
        return ResponseEntity.ok(savedPaciente); // Devolver una respuesta HTTP 200 OK con el paciente guardado
    }

    // Endpoint para obtener todos los pacientes mediante una solicitud GET
    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        List<Paciente> pacientes = pacienteService.findAll(); // Obtener todos los pacientes utilizando el servicio PacienteService
        return ResponseEntity.ok(pacientes); // Devolver una respuesta HTTP 200 OK con la lista de pacientes
    }

    // Endpoint para obtener un paciente por su ID mediante una solicitud GET
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        return pacienteService.findById(id) // Buscar el paciente por su ID utilizando el servicio PacienteService
                .map(ResponseEntity::ok) // Si se encuentra, devolver una respuesta HTTP 200 OK con el paciente encontrado
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si no se encuentra, devolver una respuesta HTTP 404 Not Found
    }

    // Endpoint para actualizar un paciente existente por su ID mediante una solicitud PUT
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        if (!pacienteService.findById(id).isPresent()) { // Verificar si el paciente con el ID proporcionado existe
            return ResponseEntity.notFound().build(); // Si no existe, devolver una respuesta HTTP 404 Not Found
        }
        paciente.setId(id); // Establecer el ID del paciente con el ID proporcionado
        Paciente updatedPaciente = pacienteService.save(paciente); // Guardar el paciente actualizado utilizando el servicio PacienteService
        return ResponseEntity.ok(updatedPaciente); // Devolver una respuesta HTTP 200 OK con el paciente actualizado
    }

    // Endpoint para eliminar un paciente por su ID mediante una solicitud DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        if (!pacienteService.findById(id).isPresent()) { // Verificar si el paciente con el ID proporcionado existe
            return ResponseEntity.notFound().build(); // Si no existe, devolver una respuesta HTTP 404 Not Found
        }
        pacienteService.deleteById(id); // Eliminar el paciente con el ID proporcionado utilizando el servicio PacienteService
        return ResponseEntity.noContent().build(); // Devolver una respuesta HTTP 204 No Content
    }

    // Endpoint para eliminar todos los pacientes mediante una solicitud DELETE
    @DeleteMapping
    public ResponseEntity<Void> deleteAllPacientes() {
        pacienteService.deleteAll(); // Eliminar todos los pacientes utilizando el servicio PacienteService
        return ResponseEntity.noContent().build(); // Devolver una respuesta HTTP 204 No Content
    }

    // Endpoint para buscar pacientes por nombre mediante una solicitud GET con parámetro "nombre"
    @GetMapping(params = "nombre")
    public ResponseEntity<List<Paciente>> findPacientesByNombre(@RequestParam String nombre) {
        List<Paciente> pacientes = pacienteService.findByNombreContaining(nombre); // Buscar pacientes por nombre utilizando el servicio PacienteService
        return ResponseEntity.ok(pacientes); // Devolver una respuesta HTTP 200 OK con la lista de pacientes encontrados
    }
}

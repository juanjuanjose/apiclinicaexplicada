package com.ClinicaApi.controller;

import com.ClinicaApi.model.Medico;
import com.ClinicaApi.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService; // Inyección de dependencia del servicio MedicoService

    // Endpoint para crear un nuevo médico mediante una solicitud POST
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medico> createMedico(@RequestBody Medico medico) {
        // Lógica para crear el médico (guardarlo en la base de datos, por ejemplo)
        // En este caso, simplemente se devuelve el médico creado con HTTP 201 Created
        return new ResponseEntity<>(medico, HttpStatus.CREATED);
    }

    // Endpoint para obtener todos los médicos mediante una solicitud GET
    @GetMapping
    public ResponseEntity<List<Medico>> getAllMedicos() {
        List<Medico> medicos = medicoService.findAll(); // Obtener todos los médicos utilizando el servicio MedicoService
        return ResponseEntity.ok(medicos); // Devolver una respuesta HTTP 200 OK con la lista de médicos
    }

    // Endpoint para obtener un médico por su ID mediante una solicitud GET
    @GetMapping("/{id}")
    public ResponseEntity<Medico> getMedicoById(@PathVariable Long id) {
        return medicoService.findById(id) // Buscar el médico por su ID utilizando el servicio MedicoService
                .map(ResponseEntity::ok) // Si se encuentra, devolver una respuesta HTTP 200 OK con el médico encontrado
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si no se encuentra, devolver una respuesta HTTP 404 Not Found
    }

    // Endpoint para actualizar un médico existente por su ID mediante una solicitud PUT
    @PutMapping("/{id}")
    public ResponseEntity<Medico> updateMedico(@PathVariable Long id, @RequestBody Medico medico) {
        if (!medicoService.findById(id).isPresent()) { // Verificar si el médico con el ID proporcionado existe
            return ResponseEntity.notFound().build(); // Si no existe, devolver una respuesta HTTP 404 Not Found
        }
        medico.setId(id); // Establecer el ID del médico con el ID proporcionado
        Medico updatedMedico = medicoService.save(medico); // Guardar el médico actualizado utilizando el servicio MedicoService
        return ResponseEntity.ok(updatedMedico); // Devolver una respuesta HTTP 200 OK con el médico actualizado
    }

    // Endpoint para eliminar un médico por su ID mediante una solicitud DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable Long id) {
        if (!medicoService.findById(id).isPresent()) { // Verificar si el médico con el ID proporcionado existe
            return ResponseEntity.notFound().build(); // Si no existe, devolver una respuesta HTTP 404 Not Found
        }
        medicoService.deleteById(id); // Eliminar el médico con el ID proporcionado utilizando el servicio MedicoService
        return ResponseEntity.noContent().build(); // Devolver una respuesta HTTP 204 No Content
    }

    // Endpoint para eliminar todos los médicos mediante una solicitud DELETE
    @DeleteMapping
    public ResponseEntity<Void> deleteAllMedicos() {
        medicoService.deleteAll(); // Eliminar todos los médicos utilizando el servicio MedicoService
        return ResponseEntity.noContent().build(); // Devolver una respuesta HTTP 204 No Content
    }

    // Endpoint para buscar médicos por nombre mediante una solicitud GET con parámetro "nombre"
    @GetMapping(params = "nombre")
    public ResponseEntity<List<Medico>> findMedicosByNombre(@RequestParam String nombre) {
        List<Medico> medicos = medicoService.findByNombreContaining(nombre); // Buscar médicos por nombre utilizando el servicio MedicoService
        return ResponseEntity.ok(medicos); // Devolver una respuesta HTTP 200 OK con la lista de médicos encontrados
    }
}

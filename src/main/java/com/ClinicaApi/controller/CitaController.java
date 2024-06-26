package com.ClinicaApi.controller;

import com.ClinicaApi.model.Cita;
import com.ClinicaApi.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService; // Inyección de dependencia del servicio CitaService

    // Endpoint para crear una nueva cita mediante una solicitud POST
    @PostMapping
    public ResponseEntity<Cita> createCita(@RequestBody Cita cita) {
        Cita savedCita = citaService.save(cita); // Guardar la cita utilizando el servicio CitaService
        return ResponseEntity.ok(savedCita); // Devolver una respuesta HTTP 200 OK con la cita guardada
    }

    // Endpoint para obtener todas las citas mediante una solicitud GET
    @GetMapping
    public ResponseEntity<List<Cita>> getAllCitas() {
        List<Cita> citas = citaService.findAll(); // Obtener todas las citas utilizando el servicio CitaService
        return ResponseEntity.ok(citas); // Devolver una respuesta HTTP 200 OK con la lista de citas
    }

    // Endpoint para obtener una cita por su ID mediante una solicitud GET
    @GetMapping("/{id}")
    public ResponseEntity<Cita> getCitaById(@PathVariable Long id) {
        return citaService.findById(id) // Buscar la cita por su ID utilizando el servicio CitaService
                .map(ResponseEntity::ok) // Si se encuentra, devolver una respuesta HTTP 200 OK con la cita encontrada
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si no se encuentra, devolver una respuesta HTTP 404 Not Found
    }

    // Endpoint para actualizar una cita existente por su ID mediante una solicitud PUT
    @PutMapping("/{id}")
    public ResponseEntity<Cita> updateCita(@PathVariable Long id, @RequestBody Cita cita) {
        if (!citaService.findById(id).isPresent()) { // Verificar si la cita con el ID proporcionado existe
            return ResponseEntity.notFound().build(); // Si no existe, devolver una respuesta HTTP 404 Not Found
        }
        cita.setId(id); // Establecer el ID de la cita con el ID proporcionado
        Cita updatedCita = citaService.save(cita); // Guardar la cita actualizada utilizando el servicio CitaService
        return ResponseEntity.ok(updatedCita); // Devolver una respuesta HTTP 200 OK con la cita actualizada
    }

    // Endpoint para eliminar una cita por su ID mediante una solicitud DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable Long id) {
        if (!citaService.findById(id).isPresent()) { // Verificar si la cita con el ID proporcionado existe
            return ResponseEntity.notFound().build(); // Si no existe, devolver una respuesta HTTP 404 Not Found
        }
        citaService.deleteById(id); // Eliminar la cita con el ID proporcionado utilizando el servicio CitaService
        return ResponseEntity.noContent().build(); // Devolver una respuesta HTTP 204 No Content
    }

    // Endpoint para eliminar todas las citas mediante una solicitud DELETE
    @DeleteMapping
    public ResponseEntity<Void> deleteAllCitas() {
        citaService.deleteAll(); // Eliminar todas las citas utilizando el servicio CitaService
        return ResponseEntity.noContent().build(); // Devolver una respuesta HTTP 204 No Content
    }
}

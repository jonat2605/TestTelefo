package com.nttdata.testTelefonica.controller;

import com.nttdata.testTelefonica.model.dto.PruebaEstudianteDto;
import com.nttdata.testTelefonica.model.dto.RespuestaDto;
import com.nttdata.testTelefonica.service.PruebaEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prueba/estudiante")
public class PruebaEstudianteController {

    @Autowired
    private PruebaEstudianteService pruebaEstudianteService;

    @GetMapping(value = "/consultar/{id}")
    ResponseEntity<RespuestaDto> consultarPruebaEstporId(@PathVariable Integer id) {
        return pruebaEstudianteService.consultarPruebaEstudiante(id);
    }

    @GetMapping(value = "/consultar")
    ResponseEntity<RespuestaDto> consultarPruebasEst() {
        return pruebaEstudianteService.consultarPruebasEstudiante();
    }

    @PostMapping(value = "/crear")
    ResponseEntity<RespuestaDto> crearPruebaEst(@RequestBody PruebaEstudianteDto pruebaEstudianteDto) {
        return pruebaEstudianteService.crearPruebaEstudiante(pruebaEstudianteDto);
    }

    @PutMapping(value = "/modificar")
    ResponseEntity<RespuestaDto> modificarPruebaEst(@RequestBody PruebaEstudianteDto pruebaEstudianteDto) {
        return pruebaEstudianteService.modificarPruebaEstudiante(pruebaEstudianteDto);
    }

    @DeleteMapping(value = "/eliminar/{id}")
    ResponseEntity<RespuestaDto> eliminarPruebaEst(@PathVariable Integer id) {
        return pruebaEstudianteService.eliminarPruebaEstudiante(id);
    }

}
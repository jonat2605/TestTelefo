package com.nttdata.testTelefonica.service;

import com.nttdata.testTelefonica.model.dto.PruebaEstudianteDto;
import com.nttdata.testTelefonica.model.dto.RespuestaDto;
import org.springframework.http.ResponseEntity;

public interface PruebaEstudianteService {

    ResponseEntity<RespuestaDto> consultarPruebaEstudiante(Integer id);

    ResponseEntity<RespuestaDto> consultarPruebasEstudiante();

    ResponseEntity<RespuestaDto> crearPruebaEstudiante(PruebaEstudianteDto pruebaEstudianteDto);

    ResponseEntity<RespuestaDto> modificarPruebaEstudiante(PruebaEstudianteDto pruebaEstudianteDto);

    ResponseEntity<RespuestaDto> eliminarPruebaEstudiante(Integer id);

}

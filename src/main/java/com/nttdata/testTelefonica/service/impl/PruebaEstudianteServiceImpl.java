package com.nttdata.testTelefonica.service.impl;

import com.nttdata.testTelefonica.model.dto.PruebaEstudianteDto;
import com.nttdata.testTelefonica.model.dto.RespuestaDto;
import com.nttdata.testTelefonica.model.entities.PruebaEstudiante;
import com.nttdata.testTelefonica.repository.PruebaEstudianteRepository;
import com.nttdata.testTelefonica.service.PruebaEstudianteService;
import com.nttdata.testTelefonica.util.Constantes;
import com.nttdata.testTelefonica.util.FuncionesGenericas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PruebaEstudianteServiceImpl implements PruebaEstudianteService {

    @Autowired
    PruebaEstudianteRepository pruebaEstudianteRepository;

    @Autowired
    FuncionesGenericas funcionesGenericas;

    @Override
    public ResponseEntity<RespuestaDto> consultarPruebaEstudiante(Integer id) {
        RespuestaDto respuesta = new RespuestaDto();
        try {

            if (id == null) {
                respuesta.setCodigo(Constantes.codigoBadRequest);
                respuesta.setDescripcion(Constantes.respuestaBadRequest);
                return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
            }

            PruebaEstudiante pruebaEstudiante = pruebaEstudianteRepository.findById(id).orElseGet(() -> null);

            if (pruebaEstudiante != null) {
                respuesta.setCodigo(Constantes.codigoCorrecta);
                respuesta.setDescripcion(Constantes.respuestaCorrecta);
                respuesta.setContenido(funcionesGenericas.mapearADto(pruebaEstudiante));
                return ResponseEntity.ok(respuesta);
            } else {
                respuesta.setCodigo(Constantes.codigoNoEncontrado);
                respuesta.setDescripcion(Constantes.respuestaNoEncontrado);
                return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            respuesta.setCodigo(Constantes.codigoFallido);
            respuesta.setDescripcion(Constantes.respuestaFallida);
            respuesta.setContenido(e);
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<RespuestaDto> consultarPruebasEstudiante() {
        RespuestaDto respuesta = new RespuestaDto();
        try {
            respuesta.setCodigo(Constantes.codigoCorrecta);
            respuesta.setDescripcion(Constantes.respuestaCorrecta);
            respuesta.setContenido(pruebaEstudianteRepository.findAll().stream().map(pruebaEstudiante -> funcionesGenericas.mapearADto(pruebaEstudiante)));
            return  ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            respuesta.setCodigo(Constantes.codigoFallido);
            respuesta.setDescripcion(Constantes.respuestaFallida);
            respuesta.setContenido(e);
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<RespuestaDto> crearPruebaEstudiante(PruebaEstudianteDto pruebaEstudianteDto) {
        RespuestaDto respuesta = new RespuestaDto();
        try {
            pruebaEstudianteRepository.save(funcionesGenericas.mapearAEntidad(pruebaEstudianteDto));
            respuesta.setCodigo(Constantes.codigoCorrecta);
            respuesta.setDescripcion(Constantes.respuestaCorrecta);
            return  ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            respuesta.setCodigo(Constantes.codigoFallido);
            respuesta.setDescripcion(Constantes.respuestaFallida);
            respuesta.setContenido(e);
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<RespuestaDto> modificarPruebaEstudiante(PruebaEstudianteDto pruebaEstudianteDto) {
        RespuestaDto respuesta = new RespuestaDto();
        try {
            if (pruebaEstudianteRepository.findById(pruebaEstudianteDto.getEid()).orElseGet(() -> null) == null) {
                respuesta.setCodigo(Constantes.codigoNoEncontrado);
                respuesta.setDescripcion(Constantes.respuestaNoEncontrado);
                return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
            } else {
                pruebaEstudianteRepository.save(funcionesGenericas.mapearAEntidad(pruebaEstudianteDto));
                respuesta.setCodigo(Constantes.codigoCorrecta);
                respuesta.setDescripcion(Constantes.respuestaCorrecta);
                return  ResponseEntity.ok(respuesta);
            }
        } catch (Exception e) {
            respuesta.setCodigo(Constantes.codigoFallido);
            respuesta.setDescripcion(Constantes.respuestaFallida);
            respuesta.setContenido(e);
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<RespuestaDto> eliminarPruebaEstudiante(Integer id) {
        RespuestaDto respuesta = new RespuestaDto();
        try {
            if (id == null) {
                respuesta.setCodigo(Constantes.codigoBadRequest);
                respuesta.setDescripcion(Constantes.respuestaBadRequest);
                return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
            } else {
                pruebaEstudianteRepository.deleteById(id);
                respuesta.setCodigo(Constantes.codigoCorrecta);
                respuesta.setDescripcion(Constantes.respuestaCorrecta);
                return  ResponseEntity.ok(respuesta);
            }
        } catch (Exception e) {
            respuesta.setCodigo(Constantes.codigoFallido);
            respuesta.setDescripcion(Constantes.respuestaFallida);
            respuesta.setContenido(e);
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

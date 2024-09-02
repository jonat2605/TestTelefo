package com.nttdata.testTelefonica.controller;

import com.nttdata.testTelefonica.model.dto.PruebaEstudianteDto;
import com.nttdata.testTelefonica.model.dto.RespuestaDto;
import com.nttdata.testTelefonica.service.PruebaEstudianteService;
import com.nttdata.testTelefonica.util.Constantes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PruebaEstudianteControllerTest {

    @Mock
    private PruebaEstudianteService pruebaEstudianteService;

    @InjectMocks
    private PruebaEstudianteController pruebaEstudianteController;

    private PruebaEstudianteDto pruebaEstudianteDto;

    @BeforeEach
    void setDatos() {
         pruebaEstudianteDto = new PruebaEstudianteDto(
                01,
                "Jonathan",
                "Matematicas",
                "GR"
                );
    }

    @Test
    public void consultarPruebaPorIdCorrecto() {
        Integer id = 01;
        RespuestaDto respuestaDto = new RespuestaDto();
        respuestaDto.setCodigo(Constantes.codigoCorrecta);
        respuestaDto.setDescripcion(Constantes.respuestaCorrecta);
        respuestaDto.setContenido(pruebaEstudianteDto);
        Mockito.when(pruebaEstudianteService.consultarPruebaEstudiante(id)).thenReturn(ResponseEntity.ok(respuestaDto));
        assertEquals(HttpStatus.OK, pruebaEstudianteController.consultarPruebaEstporId(id).getStatusCode());
    }

    @Test
    public void consultarPruebaPorIdNulo() {
        RespuestaDto respuestaDto = new RespuestaDto();
        respuestaDto.setCodigo(Constantes.codigoBadRequest);
        respuestaDto.setDescripcion(Constantes.respuestaBadRequest);
        Mockito.when(pruebaEstudianteService.consultarPruebaEstudiante(Mockito.any())).thenReturn(new ResponseEntity<>(respuestaDto, HttpStatus.BAD_REQUEST));
        assertEquals(HttpStatus.BAD_REQUEST, pruebaEstudianteController.consultarPruebaEstporId(null).getStatusCode());
    }

    @Test
    public void consultarListaPruebasOk() {
        RespuestaDto respuestaDto = new RespuestaDto();
        respuestaDto.setCodigo(Constantes.codigoCorrecta);
        respuestaDto.setDescripcion(Constantes.respuestaCorrecta);
        respuestaDto.setContenido(Stream.of(pruebaEstudianteDto).toArray());
        Mockito.when(pruebaEstudianteService.consultarPruebasEstudiante()).thenReturn(ResponseEntity.ok(respuestaDto));
        assertEquals(HttpStatus.OK, pruebaEstudianteController.consultarPruebasEst().getStatusCode());
    }

    @Test
    public void crearPruebaEstudianteOk() {
        RespuestaDto respuestaDto = new RespuestaDto();
        respuestaDto.setCodigo(Constantes.codigoCorrecta);
        respuestaDto.setDescripcion(Constantes.respuestaCorrecta);
        Mockito.when(pruebaEstudianteService.crearPruebaEstudiante(pruebaEstudianteDto)).thenReturn(ResponseEntity.ok(respuestaDto));
        assertEquals(HttpStatus.OK, pruebaEstudianteController.crearPruebaEst(pruebaEstudianteDto).getStatusCode());
    }

    @Test
    public void modificarPruebaEstudianteOk() {
        RespuestaDto respuestaDto = new RespuestaDto();
        respuestaDto.setCodigo(Constantes.codigoCorrecta);
        respuestaDto.setDescripcion(Constantes.respuestaCorrecta);
        Mockito.when(pruebaEstudianteService.modificarPruebaEstudiante(pruebaEstudianteDto)).thenReturn(ResponseEntity.ok(respuestaDto));
        assertEquals(HttpStatus.OK, pruebaEstudianteController.modificarPruebaEst(pruebaEstudianteDto).getStatusCode());
    }

    @Test
    public void eliminarPruebaEstudianteOk() {
        Integer id = 01;
        RespuestaDto respuestaDto = new RespuestaDto();
        respuestaDto.setCodigo(Constantes.codigoCorrecta);
        respuestaDto.setDescripcion(Constantes.respuestaCorrecta);
        Mockito.when(pruebaEstudianteService.eliminarPruebaEstudiante(id)).thenReturn(ResponseEntity.ok(respuestaDto));
        assertEquals(HttpStatus.OK, pruebaEstudianteController.eliminarPruebaEst(id).getStatusCode());
    }

}

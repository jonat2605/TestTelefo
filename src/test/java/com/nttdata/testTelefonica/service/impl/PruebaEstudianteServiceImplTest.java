package com.nttdata.testTelefonica.service.impl;

import com.nttdata.testTelefonica.model.dto.PruebaEstudianteDto;
import com.nttdata.testTelefonica.model.entities.PruebaEstudiante;
import com.nttdata.testTelefonica.repository.PruebaEstudianteRepository;
import com.nttdata.testTelefonica.util.FuncionesGenericas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class PruebaEstudianteServiceImplTest {

    @InjectMocks
    private PruebaEstudianteServiceImpl pruebaEstudianteService;

    @Mock
    private PruebaEstudianteRepository pruebaEstudianteRepository;

    @Mock
    FuncionesGenericas funcionesGenericas;

    private PruebaEstudianteDto pruebaEstudianteDto;

    private PruebaEstudiante pruebaEstudianteEntidad;

    @BeforeEach
    void setDatos() {
        pruebaEstudianteDto = new PruebaEstudianteDto(
                01,
                "Jonathan",
                "Matematicas",
                "GR"
        );

        pruebaEstudianteEntidad = new PruebaEstudiante();
        pruebaEstudianteEntidad.setEid(1);
        pruebaEstudianteEntidad.setEspecialidad("Matematicas");
        pruebaEstudianteEntidad.setNombre("Jonathan");
        pruebaEstudianteEntidad.setGrado("GR");
    }

    @Test
    public void consultarPruebaEstudiantePorIdOk() {
        Integer id = 1;
        doReturn(Optional.of(pruebaEstudianteEntidad)).when(pruebaEstudianteRepository).findById(id);
        assertEquals(HttpStatus.OK, pruebaEstudianteService.consultarPruebaEstudiante(id).getStatusCode());
    }

    @Test
    public void consultarPruebaEstudiantePorIdNoExistente() {
        Integer id = 1;
        doReturn(Optional.empty()).when(pruebaEstudianteRepository).findById(id);
        assertEquals(HttpStatus.NOT_FOUND, pruebaEstudianteService.consultarPruebaEstudiante(id).getStatusCode());
    }

    @Test
    public void consultarPruebaEstudiantePorIdNulo() {
        assertEquals(HttpStatus.BAD_REQUEST, pruebaEstudianteService.consultarPruebaEstudiante(null).getStatusCode());
    }

    @Test
    public void consultarPruebaEstudianteInternalError() {
        Mockito.when(pruebaEstudianteService.consultarPruebaEstudiante(Mockito.anyInt())).thenThrow(new RuntimeException());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, pruebaEstudianteService.consultarPruebaEstudiante(1).getStatusCode());
    }

    @Test
    public void consultarPruebasEstudiantesOk() {
        assertEquals(HttpStatus.OK, pruebaEstudianteService.consultarPruebasEstudiante().getStatusCode());
    }

    @Test
    public void consultarPruebasEstudiantesInternalError() {
        Mockito.when(pruebaEstudianteService.consultarPruebasEstudiante()).thenThrow(new RuntimeException());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, pruebaEstudianteService.consultarPruebasEstudiante().getStatusCode());
    }

    @Test
    public void crearPruebaEstudianteOk() {
        assertEquals(HttpStatus.OK, pruebaEstudianteService.crearPruebaEstudiante(pruebaEstudianteDto).getStatusCode());
    }

    @Test
    public void crearPruebaEstudianteInternalError() {
        Mockito.when(pruebaEstudianteService.crearPruebaEstudiante(pruebaEstudianteDto)).thenThrow(new RuntimeException());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, pruebaEstudianteService.crearPruebaEstudiante(pruebaEstudianteDto).getStatusCode());
    }

    @Test
    public void modificarPruebaEstudianteOk() {
        doReturn(Optional.of(pruebaEstudianteEntidad)).when(pruebaEstudianteRepository).findById(pruebaEstudianteDto.getEid());
        assertEquals(HttpStatus.OK, pruebaEstudianteService.modificarPruebaEstudiante(pruebaEstudianteDto).getStatusCode());
    }

    @Test
    public void modificarPruebaEstudianteNoEncontrado() {
        doReturn(Optional.empty()).when(pruebaEstudianteRepository).findById(pruebaEstudianteDto.getEid());
        assertEquals(HttpStatus.NOT_FOUND, pruebaEstudianteService.modificarPruebaEstudiante(pruebaEstudianteDto).getStatusCode());
    }

    @Test
    public void modificarPruebaEstudianteInternalError() {
        Mockito.when(pruebaEstudianteService.modificarPruebaEstudiante(pruebaEstudianteDto)).thenThrow(new RuntimeException());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, pruebaEstudianteService.modificarPruebaEstudiante(pruebaEstudianteDto).getStatusCode());
    }

    @Test
    public void eliminarPruebaEstudianteOk() {
        assertEquals(HttpStatus.OK, pruebaEstudianteService.eliminarPruebaEstudiante(1).getStatusCode());
    }

    @Test
    public void eliminarPruebaEstudianteNulo() {
        assertEquals(HttpStatus.BAD_REQUEST, pruebaEstudianteService.eliminarPruebaEstudiante(null).getStatusCode());
    }

    @Test
    public void eliminarPruebaEstudianteInternalError() {
        Mockito.when(pruebaEstudianteService.eliminarPruebaEstudiante(1)).thenThrow(new RuntimeException());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, pruebaEstudianteService.eliminarPruebaEstudiante(1).getStatusCode());
    }

}

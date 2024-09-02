package com.nttdata.testTelefonica.util;

import com.nttdata.testTelefonica.model.dto.PruebaEstudianteDto;
import com.nttdata.testTelefonica.model.entities.PruebaEstudiante;
import org.modelmapper.ModelMapper;

public class FuncionesGenericas {

    public PruebaEstudianteDto mapearADto(PruebaEstudiante pruebaEstudiante) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(pruebaEstudiante, PruebaEstudianteDto.class);
    }

    public PruebaEstudiante mapearAEntidad(PruebaEstudianteDto pruebaEstudianteDto){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(pruebaEstudianteDto, PruebaEstudiante.class);
    }

}

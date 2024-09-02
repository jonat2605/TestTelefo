package com.nttdata.testTelefonica.model.dto;

public class PruebaEstudianteDto {

    private Integer eid;
    private String nombre;
    private String especialidad;
    private String grado;

    public PruebaEstudianteDto(Integer eid, String nombre, String especialidad, String grado) {
        this.eid = eid;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.grado = grado;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
}

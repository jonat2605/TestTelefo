package com.nttdata.testTelefonica.util;

public class CalcularArea {

    private Double calcularAreaTriangulo(Double base, Double altura) throws Exception {
        try {
            return (base * altura) / 2;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private Double calcularAreaCirculo(Double radio) throws Exception {
        try {
            return Math.PI * Math.pow(radio, 2);
            // return Math.PI * (radio * radio);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}

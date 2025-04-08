package com.javier.Ej10;

import java.time.LocalDate;
import java.time.Period;

public class Hijo {
    private String nombre;
    private LocalDate fechaNac;

    public Hijo(String nombre, LocalDate fechaNac) {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        Period periodo = Period.between(fechaNac, LocalDate.now());
        return periodo.getYears();
    }


}

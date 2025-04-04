package com.javier.Ej5;
import java.time.LocalDate;
import java.time.Period;


public class Paciente {
    static int auto = 0;

    private final int id;
    private final String nombre;
    private final LocalDate fechaNac;
    private final char sexo;
    private final int altural;
    private final double peso;


    public Paciente(String nombre, LocalDate fechaNac, char sexo, int altural, double peso) {
        this.id = ++auto;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.altural = altural;
        this.peso = peso;
    }



    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public char getSexo() {
        return sexo;
    }

    public int getAltural() {
        return altural;
    }

    public double getPeso() {
        return peso;
    }

    public int getEdad() {
        Period periodo = Period.between(fechaNac, LocalDate.now());
        return periodo.getYears();
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + getEdad() +
                ", sexo=" + sexo +
                ", altural=" + altural +
                ", peso=" + peso +
                '}';
    }
}

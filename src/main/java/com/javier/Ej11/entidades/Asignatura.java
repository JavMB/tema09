package com.javier.Ej11.entidades;

import java.util.Objects;

public class Asignatura {
    private static int auto;

    private final int id;
    private final String nombre;
    private final Profesor profesor;


    public Asignatura(String nombre, Profesor profesor) {
        this.id = ++auto;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", profesor=" + profesor +
                '}';
    }
}

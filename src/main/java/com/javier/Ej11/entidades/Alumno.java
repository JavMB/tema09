package com.javier.Ej11.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alumno {
    private static int auto;

    private final int id;
    private final String nombre;
    private final Grupo grupo;
    private final List<Asignatura> asignaturas;

    public Alumno(String nombre, Grupo grupo) {
        this.id = ++auto;
        this.nombre = nombre;
        this.grupo = grupo;
        this.asignaturas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return id == alumno.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", grupo=" + grupo +
                ", asignaturas=" + asignaturas +
                '}';
    }
}

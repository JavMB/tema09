package com.javier.Ej11.entidades;

import java.util.Objects;

public class Grupo {
    private static int auto;

    private final int id;
    private final String nombre;
    private final Aula aula;

    public Grupo(String nombre, Aula aula) {
        this.id =++auto;
        this.nombre = nombre;
        this.aula = aula;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Aula getAula() {
        return aula;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return id == grupo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", aula=" + aula +
                '}';
    }
}

package com.javier.Ej11.entidades;

import java.util.Objects;

public class Aula {
    private static int auto;

    private final int id;
    private final int m2;


    public Aula(int m2) throws IllegalArgumentException {
        this.id = ++auto;
        if (m2 <= 0) {
            throw new IllegalArgumentException();
        } else this.m2 = m2;
    }

    public int getId() {
        return id;
    }

    public int getM2() {
        return m2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return id == aula.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Aula{" +
                "id=" + id +
                ", m2=" + m2 +
                '}';
    }
}

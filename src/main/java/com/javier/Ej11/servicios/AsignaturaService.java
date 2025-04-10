package com.javier.Ej11.servicios;

import com.javier.Ej11.entidades.Asignatura;

import java.util.HashSet;
import java.util.Set;

 class AsignaturaService implements Gestionable<Asignatura,Integer> {

    private final Set<Asignatura> asignaturas;

     AsignaturaService() {
        this.asignaturas = new HashSet<>();
    }

    @Override
    public void add(Asignatura e) {
        asignaturas.add(e);
    }

    @Override
    public Asignatura get(Integer K) {
        for (Asignatura a : asignaturas) {
            if (a.getId() == K) {
                return a;
            }

        }
        return null;
    }


}

package com.javier.Ej11.servicios;

import com.javier.Ej11.entidades.Profesor;

import java.util.HashMap;
import java.util.Map;

class ProfesorService implements Gestionable<Profesor, String> {
    private final Map<String, Profesor> profesores;

    ProfesorService() {
        this.profesores = new HashMap<>();
    }

    @Override
    public void add(Profesor e) {
        if (!profesores.containsKey(e.getDni())) {
            profesores.put(e.getDni(), e);
        }

    }

    @Override
    public Profesor get(String clave) {
        return profesores.get(clave);
    }


}

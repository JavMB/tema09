package com.javier.Ej11.servicios;

import com.javier.Ej11.entidades.Alumno;

import java.util.HashMap;
import java.util.Map;

 class AlumnoService implements Gestionable<Alumno,Integer> {
    private final Map<Integer, Alumno> alumnos;


     AlumnoService() {
        this.alumnos = new HashMap<>();
    }

    @Override
    public void add(Alumno alumno) {
        if (!alumnos.containsKey(alumno.getId())) {
            alumnos.put(alumno.getId(), alumno);
        }

    }

    @Override
    public Alumno get(Integer K) {
        return alumnos.get(K);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();


        for (Map.Entry<Integer, Alumno> par : alumnos.entrySet()) {

            sb.append(par.getValue()).append("\n");

        }


        return sb.toString();
    }
}

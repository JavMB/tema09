package com.javier.Ej11.servicios;

import com.javier.Ej11.entidades.Aula;

import java.util.HashMap;
import java.util.Map;

class AulasService implements Gestionable<Aula, Integer> {
    private final Map<Integer, Aula> aulas;

    AulasService() {
        this.aulas = new HashMap<>();
    }

    @Override
    public void add(Aula e) {
        if (!aulas.containsKey(e.getId())) {
            aulas.put(e.getId(), e);

        }

    }

    @Override
    public Aula get(Integer K) {
        return aulas.get(K);
    }


}

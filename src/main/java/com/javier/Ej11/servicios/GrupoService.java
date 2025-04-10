package com.javier.Ej11.servicios;

import com.javier.Ej11.entidades.Grupo;

import java.util.HashMap;
import java.util.Map;

class GrupoService implements Gestionable<Grupo, Integer> {
    private final Map<Integer, Grupo> grupos;

    GrupoService() {
        this.grupos = new HashMap<>();
    }

    @Override
    public void add(Grupo e) {
        if (!grupos.containsKey(e.getId())) {
            grupos.put(e.getId(), e);
        }

    }

    @Override
    public Grupo get(Integer K) {
        return grupos.get(K);
    }


}

package com.javier.Ej6;

import java.util.HashMap;
import java.util.Map;

public class Traductor {
    private final Map<String, String> traductor;

    public Traductor() {
        this.traductor = new HashMap<>();
    }

    public boolean add(String clave, String valor) {
        if (!traductor.containsKey(clave)) {
            traductor.put(clave, valor);
            return true;
        } else return false;

    }

    public String traducir(String clave) {
        return traductor.getOrDefault(clave, "");
    }
}

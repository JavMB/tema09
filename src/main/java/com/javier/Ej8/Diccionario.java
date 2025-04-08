package com.javier.Ej8;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Diccionario {
    protected final Map<String, String> dict = new HashMap<>();

    /**
     *
     * @param palabra palabra para anadir
     * @param def definicion para agregar
     * @return true o false si se logra
     */
    public boolean add(String palabra, String def) {
        if (palabra == null || def == null) return false;

        if (contains(palabra)) {
            return false;
        }

        dict.put(palabra, def);
        return true;
    }

    /**
     *
     * @param palabra palabra a modificar
     * @param nuevaDef nueva definicion
     * @return
     */
    public boolean mod(String palabra, String nuevaDef) {
        if (palabra == null || nuevaDef == null) return false;

        if (!contains(palabra)) {
            return false;
        }

        dict.put(palabra, nuevaDef);
        return true;
    }

    /**
     *
     * @param palabra palabra a eliminar
     * @return devuelve true si se elimina o false
     */
    public boolean remove(String palabra) {
        if (palabra == null) return false;

        if (!contains(palabra)) {
            return false;
        }

        dict.remove(palabra);
        return true;
    }

    /**
     *
     * @param palabra palabra a buscar
     * @return devuelve la definicion
     */
    public String search(String palabra) {
        if (palabra == null) return null;
        return dict.get(palabra);
    }

    /**
     *  mostrar todas las entradas del diccionario
     */
    public void showAll() {
        for (Entry<String, String> entry : dict.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    /**
     *
     * @param palabra palabra a comprobar
     * @return true o false si lo encuentra
     */
    public boolean contains(String palabra) {
        if (palabra == null) return false;
        return dict.containsKey(palabra);
    }
}
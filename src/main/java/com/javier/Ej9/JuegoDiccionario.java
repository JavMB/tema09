package com.javier.Ej9;

import java.util.*;

public class JuegoDiccionario {
    private final Map<String, String> diccionario = new HashMap<>();
    private final Map<String, Integer> podium = new LinkedHashMap<>();


    // Métodos básicos del diccionario
    public boolean agregarPalabra(String palabra, String definicion) {
        if (palabra == null || definicion == null || palabra.isEmpty() || definicion.isEmpty()) {
            return false;
        }
        String clave = palabra.toLowerCase();
        if (diccionario.containsKey(clave)) {
            return false;
        }
        diccionario.put(clave, definicion);
        return true;
    }

    public boolean modificarPalabra(String palabra, String nuevaDefinicion) {
        if (palabra == null || nuevaDefinicion == null || palabra.isEmpty() || nuevaDefinicion.isEmpty()) {
            return false;
        }
        String clave = palabra.toLowerCase();
        if (!diccionario.containsKey(clave)) {
            return false;
        }
        diccionario.put(clave, nuevaDefinicion);
        return true;
    }

    public boolean eliminarPalabra(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return false;
        }
        return diccionario.remove(palabra.toLowerCase()) != null;
    }

    public String buscarPalabra(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return null;
        }
        return diccionario.get(palabra.toLowerCase());
    }

    public Map<String, String> obtenerTodasPalabras() {
        return new HashMap<>(diccionario);
    }

    // Métodos del juego
    public String[] obtenerPalabraAleatoria() {
        if (diccionario.isEmpty()) {
            return null;
        }
        List<String> palabras = new ArrayList<>(diccionario.keySet());
        String palabraAleatoria = palabras.get(new Random().nextInt(palabras.size()));
        return new String[]{palabraAleatoria, diccionario.get(palabraAleatoria)};
    }

    public boolean verificarRespuesta(String palabraCorrecta, String respuestaUsuario) {
        return palabraCorrecta.equalsIgnoreCase(respuestaUsuario);
    }

    public void agregarPuntuacion(String nombre, int puntos) {

        if (!podium.containsKey(nombre)) {
            podium.put(nombre, puntos);
        } else {

            int puntuacionActual = podium.get(nombre);
            if (puntos > puntuacionActual) {
                podium.put(nombre, puntos);
            }
        }


        mantenerMejoresPuntuaciones();
    }


    private void mantenerMejoresPuntuaciones() {

        List<Map.Entry<String, Integer>> lista = new ArrayList<>(podium.entrySet());
        lista.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));


        if (lista.size() > 5) {
            for (int i = 5; i < lista.size(); i++) {
                podium.remove(lista.get(i).getKey());
            }
        }
    }


    public Map<String, Integer> obtenerMejoresPuntuaciones() {
        return new LinkedHashMap<>(podium);
    }


    public boolean esPuntuacionAlta(int puntos) {
        if (podium.size() < 5) {
            return true;
        }

        return puntos > Collections.min(podium.values());
    }
}

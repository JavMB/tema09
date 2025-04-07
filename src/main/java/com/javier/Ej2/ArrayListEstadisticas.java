package com.javier.Ej2;

import java.util.*;


public class ArrayListEstadisticas implements IEstadisticas {
    private final List<Double> list;

    public ArrayListEstadisticas(List<Double> list) {
        this.list = list;
    }

    @Override
    public double minimo() {
        return list.stream().min(Comparator.naturalOrder()).orElseThrow();
    }

    @Override
    public double maximo() {
        return list.stream().max(Comparator.naturalOrder()).orElseThrow();
    }

    @Override
    public double sumatorio() {
        double sumatorio = 0;
        for (double num : list) {
            sumatorio += num;
        }
        return sumatorio;
    }

    @Override
    public double media() {
        return sumatorio() / list.size();
    }

    @Override
    public double moda() {
        if (list.isEmpty()) {
            throw new IllegalStateException("La lista no puede estar vacía");
        }

        // 1. Calcular repeticiones
        HashMap<Double, Integer> repeticiones = new HashMap<>();
        for (double numero : list) {
            repeticiones.put(numero, repeticiones.getOrDefault(numero, 0) + 1);
        }

        // 2. Encontrar la moda usando entrySet()
        double moda = list.getFirst();
        int maxFrecuencia = repeticiones.get(moda);

        for (Map.Entry<Double, Integer> entry : repeticiones.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                moda = entry.getKey();
                maxFrecuencia = entry.getValue();
            }
        }

        return moda;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", ArrayListEstadisticas.class.getSimpleName() + "[", "]")
                .add("list=" + list)
                .toString();
    }
}

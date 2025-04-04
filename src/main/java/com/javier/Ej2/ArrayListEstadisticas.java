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
        HashMap<Double, Integer> frecuencias = new HashMap<>();
        Integer repeticiones;
        Double moda;

        if (!list.isEmpty()) {
            moda = list.get(0);
        } else {
            throw new IllegalStateException("La lista no puede estar vacia");
        }

        for (double numero : list) {
            repeticiones = frecuencias.getOrDefault(numero, 0);
            repeticiones++;
            frecuencias.put(numero, repeticiones);

            if (repeticiones > frecuencias.get(moda)) {
                moda = numero;
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

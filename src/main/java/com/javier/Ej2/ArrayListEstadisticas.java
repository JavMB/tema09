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
        HashMap<Double, Integer> numsMap = new HashMap<>();
        Integer cantidadRepeticionesDelDouble;
        Double doubleconMayorNumeroRepeticiones;

        if (!list.isEmpty()) {
            doubleconMayorNumeroRepeticiones = list.get(0);
        } else throw new IllegalStateException("La lista no puede estar vacia");


        for (double doubleKey : list) {
            cantidadRepeticionesDelDouble = numsMap.getOrDefault(doubleKey, 0);
            cantidadRepeticionesDelDouble++;
            numsMap.put(doubleKey, cantidadRepeticionesDelDouble);

            if (cantidadRepeticionesDelDouble > numsMap.get(doubleconMayorNumeroRepeticiones)) {
                doubleconMayorNumeroRepeticiones = doubleKey;
            }
        }

        return doubleconMayorNumeroRepeticiones;

    }


    @Override
    public String toString() {
        return new StringJoiner(", ", ArrayListEstadisticas.class.getSimpleName() + "[", "]")
                .add("list=" + list)
                .toString();
    }
}

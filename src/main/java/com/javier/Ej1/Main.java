package com.javier.Ej1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    /*
    1. Implementa un métod que reciba como parámetro una Array de números enteros y devuelva una
    lista (ArrayList) en la que primero aparezcan los números pares y después los impares.

    Posteriormente, genera una lista de 10 números enteros aleatorios entre 0 y 50 y aplica el métod
    anterior. Un ejemplo de ejecución del programa sería:
    Array generado:
    [47, 14, 28, 10, 33, 15, 26, 7, 8, 28]
    ArrayList con pares-impares:
    [14, 28, 10, 26, 8, 28, 47, 33, 15, 7]
     */

    public static void main(String[] args) {
        int[] nums = new int[50];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(51);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(generar(nums));

    }

    public static List<Integer> generar(int[] nums) {
        List<Integer> listaPares = new ArrayList<>();
        List<Integer> listaImpares = new ArrayList<>();

        for (int numero : nums) {
            if (numero % 2 == 0) {
                listaPares.add(numero);
            } else listaImpares.add(numero);
        }

        listaPares.addAll(listaImpares);

        return listaPares;


    }

}

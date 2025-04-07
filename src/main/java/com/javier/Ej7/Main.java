package com.javier.Ej7;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Conversor c = new Conversor();
        c.llenarMonedas();


        System.out.println("Dime a que moneda quieres convertir ej (USD) : ");
        String moneda = sc.nextLine();
        System.out.println("Que cantidad de euros:");
        double cantidad = Double.parseDouble(sc.nextLine());

        System.out.println("La conversion sale a : " + c.convertir(cantidad, moneda) + " "+ moneda );

    }
}

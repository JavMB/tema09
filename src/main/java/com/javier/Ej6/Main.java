package com.javier.Ej6;
import lib.IO;

import java.util.Scanner;

public class Main {
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        Traductor traductor = new Traductor();

        do {
            switch (menu()) {
                case 1 -> {
                    System.out.println("Cuantas parejas desea introducir?");
                    int num = Integer.parseInt(sc.nextLine());
                    while (num > 0) {
                        String palabra1, palabra2;
                        palabra1 = IO.readString("Introduce palabra en ingles");
                        palabra2 = IO.readString("Introduce palabra en valenciano");

                        traductor.add(palabra1, palabra2);
                        num--;
                    }

                }
                case 2 -> {
                    String palabra;
                    System.out.println("Palabra a buscar:");
                    palabra = sc.nextLine();
                    System.out.println(traductor.traducir(palabra));

                }
                case 0 -> {
                    salir = true;
                }
            }
        } while (!salir);


    }


    static int menu() {
        System.out.println("MENÚ PRINCIPAL\n" +
                "==============\n" +
                "1. Introducir parejas de palabras.\n" +
                "2. Traducir palabras.\n" +
                "0. Salir de la aplicación.");
        return Integer.parseInt(sc.nextLine());
    }


}



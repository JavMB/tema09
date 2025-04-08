package com.javier.Ej8;

import lib.IO;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Diccionario diccionario = new Diccionario();
        while (true) {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            int opcion = Integer.parseInt(sc.nextLine());


            switch (opcion) {
                case 1:
                    String palabraAñadir = IO.readString("Introduce la palabra a añadir: ");
                    String definicionAñadir = IO.readString("Introduce la definición: ");
                    diccionario.add(palabraAñadir, definicionAñadir);
                    break;
                case 2:
                    String palabraModificar = IO.readString("Introduce la palabra a modificar: ");

                    String nuevaDefinicion = IO.readString("Introduce la nueva definición: ");
                    diccionario.mod(palabraModificar, nuevaDefinicion);
                    break;
                case 3:

                    String palabraEliminar = IO.readString("Introduce la palabra a eliminar: ");
                    diccionario.remove(palabraEliminar);
                    break;
                case 4:

                    String palabraConsultar = IO.readString("Introduce la palabra a consultar: ");
                    diccionario.search(palabraConsultar);
                    break;
                case 5:
                    diccionario.showAll();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {

        System.out.println("* GESTIÓN DICCIONARIO *");
        System.out.println("***********************");
        System.out.println("1. Añadir palabra");
        System.out.println("2. Modificar palabra");
        System.out.println("3. Eliminar palabra");
        System.out.println("4. Consultar palabra");
        System.out.println("5. Mostrar diccionario");
        System.out.println("---------------------");
        System.out.println("0. Salir");


    }
}
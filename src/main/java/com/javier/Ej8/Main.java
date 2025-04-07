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
                    System.out.print("Introduce la palabra a añadir: ");
                    String palabraAñadir = IO.leerTexto();
                    System.out.print("Introduce la definición: ");
                    String definicionAñadir = IO.leerTexto();
                    diccionario.add(palabraAñadir, definicionAñadir);
                    break;
                case 2:
                    System.out.print("Introduce la palabra a modificar: ");
                    String palabraModificar = IO.leerTexto();
                    System.out.print("Introduce la nueva definición: ");
                    String nuevaDefinicion = IO.leerTexto();
                    diccionario.mod(palabraModificar, nuevaDefinicion);
                    break;
                case 3:
                    System.out.print("Introduce la palabra a eliminar: ");
                    String palabraEliminar = IO.leerTexto();
                    diccionario.remove(palabraEliminar);
                    break;
                case 4:
                    System.out.print("Introduce la palabra a consultar: ");
                    String palabraConsultar = IO.leerTexto();
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
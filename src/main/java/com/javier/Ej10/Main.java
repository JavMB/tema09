package com.javier.Ej10;

import lib.IO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionEmpleados gestionEmpleados = new GestionEmpleados();
        int opcion;

        do {
            mostrarMenu();
            opcion = IO.readInt("");

            switch (opcion) {
                case 1: nuevoEmpleado(gestionEmpleados, scanner); break;
                case 2: nuevoHijo(gestionEmpleados, scanner); break;
                case 3: modificarSueldo(gestionEmpleados, scanner); break;
                case 4: borrarEmpleado(gestionEmpleados, scanner); break;
                case 5: borrarHijo(gestionEmpleados, scanner); break;
                case 6: consultas(gestionEmpleados, scanner); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida."); break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n*********************");
        System.out.println("* GESTIÓN EMPLEADOS *");
        System.out.println("*********************");
        System.out.println("1. Nuevo empleado");
        System.out.println("2. Nuevo hijo");
        System.out.println("3. Modificar sueldo");
        System.out.println("4. Borrar empleado");
        System.out.println("5. Borrar hijo");
        System.out.println("6. Consultas");
        System.out.println("---------------------");
        System.out.println("0. Salir");
    }

    private static void nuevoEmpleado(GestionEmpleados gestion, Scanner scanner) {
        // agregar un nuevo empleado
    }

    private static void nuevoHijo(GestionEmpleados gestion, Scanner scanner) {
        // agregar un nuevo hijo a un empleado
    }

    private static void modificarSueldo(GestionEmpleados gestion, Scanner scanner) {
        //modificar el sueldo de un empleado
    }

    private static void borrarEmpleado(GestionEmpleados gestion, Scanner scanner) {
        //borrar un empleado
    }

    private static void borrarHijo(GestionEmpleados gestion, Scanner scanner) {
        //borrar un hijo de un empleado
    }

    private static void consultas(GestionEmpleados gestion, Scanner scanner) {
        int opcion;
        do {
            mostrarSubmenuConsultas();
            opcion = IO.readInt("");

            switch (opcion) {
                case 1: buscarPorNif(gestion, scanner); break;
                case 2: buscarPorNombre(gestion, scanner); break;
                case 3: buscarPorRangoEdad(gestion, scanner); break;
                case 4: buscarPorRangoSueldo(gestion, scanner); break;
                case 5: buscarPorHijosMenores(gestion); break;
                case 0: break;
                default: System.out.println("Opción no válida."); break;
            }
        } while (opcion != 0);
    }

    private static void mostrarSubmenuConsultas() {
        System.out.println("\n***********************");
        System.out.println("* CONSULTAS EMPLEADOS *");
        System.out.println("***********************");
        System.out.println("1. Buscar por NIF");
        System.out.println("2. Buscar por nombre");
        System.out.println("3. Buscar por rango de edad");
        System.out.println("4. Buscar por rango de sueldo");
        System.out.println("5. Buscar por hijos menores de edad");
        System.out.println("-----------------------------");
        System.out.println("0. Volver al menú principal");
    }

    // Métodos para cada consulta
    private static void buscarPorNif(GestionEmpleados gestion, Scanner scanner) {
        //  buscar por NIF
    }

    private static void buscarPorNombre(GestionEmpleados gestion, Scanner scanner) {
        //  buscar por nombre
    }

    private static void buscarPorRangoEdad(GestionEmpleados gestion, Scanner scanner) {
        //  buscar por rango de edad
    }

    private static void buscarPorRangoSueldo(GestionEmpleados gestion, Scanner scanner) {
        //  buscar por rango de sueldo
    }

    private static void buscarPorHijosMenores(GestionEmpleados gestion) {
        // buscar por hijos menores de edad
    }
}

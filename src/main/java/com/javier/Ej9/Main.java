package com.javier.Ej9;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        JuegoDiccionario juego = new JuegoDiccionario();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1: agregarPalabra(juego, scanner); break;
                case 2: modificarPalabra(juego, scanner); break;
                case 3: eliminarPalabra(juego, scanner); break;
                case 4: consultarPalabra(juego, scanner); break;
                case 5: mostrarDiccionario(juego); break;
                case 6: jugar(juego, scanner); break;
                case 7: mostrarPuntuaciones(juego); break;
                case 0: System.out.println("Saliendo del programa..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n*********************");
        System.out.println("* JUEGO DICCIONARIO *");
        System.out.println("*********************");
        System.out.println("1. Añadir palabra");
        System.out.println("2. Modificar palabra");
        System.out.println("3. Eliminar palabra");
        System.out.println("4. Consultar palabra");
        System.out.println("5. Mostrar diccionario");
        System.out.println("6. Jugar");
        System.out.println("7. Mejores puntuaciones");
        System.out.println("---------------------");
        System.out.println("0. Salir");
    }

    private static int leerOpcion(Scanner scanner) {
        try {
            System.out.print("Seleccione una opción: ");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;  // Si no se puede convertir a número, devolver -1
        }
    }

    private static void agregarPalabra(JuegoDiccionario juego, Scanner scanner) {
        System.out.print("Ingrese la palabra: ");
        String palabra = scanner.nextLine();
        System.out.print("Ingrese la definición: ");
        String definicion = scanner.nextLine();

        if (juego.agregarPalabra(palabra, definicion)) {
            System.out.println("Palabra añadida correctamente.");
        } else {
            System.out.println("No se pudo añadir la palabra.");
        }
    }

    private static void modificarPalabra(JuegoDiccionario juego, Scanner scanner) {
        System.out.print("Ingrese la palabra a modificar: ");
        String palabra = scanner.nextLine();
        System.out.print("Ingrese la nueva definición: ");
        String definicion = scanner.nextLine();

        if (juego.modificarPalabra(palabra, definicion)) {
            System.out.println("Palabra modificada correctamente.");
        } else {
            System.out.println("No se pudo modificar la palabra.");
        }
    }

    private static void eliminarPalabra(JuegoDiccionario juego, Scanner scanner) {
        System.out.print("Ingrese la palabra a eliminar: ");
        String palabra = scanner.nextLine();

        if (juego.eliminarPalabra(palabra)) {
            System.out.println("Palabra eliminada correctamente.");
        } else {
            System.out.println("No se pudo eliminar la palabra.");
        }
    }

    private static void consultarPalabra(JuegoDiccionario juego, Scanner scanner) {
        System.out.print("Ingrese la palabra a consultar: ");
        String palabra = scanner.nextLine();
        String definicion = juego.buscarPalabra(palabra);

        if (definicion != null) {
            System.out.println("Definición: " + definicion);
        } else {
            System.out.println("La palabra no existe.");
        }
    }

    private static void mostrarDiccionario(JuegoDiccionario juego) {
        Map<String, String> palabras = juego.obtenerTodasPalabras();
        if (palabras.isEmpty()) {
            System.out.println("El diccionario está vacío.");
            return;
        }

        for (Map.Entry<String, String> entrada : palabras.entrySet()) {
            System.out.println(entrada.getKey() + " - " + entrada.getValue());
        }
    }

    private static void jugar(JuegoDiccionario juego, Scanner scanner) {
        String[] palabraAleatoria = juego.obtenerPalabraAleatoria();
        if (palabraAleatoria == null) {
            System.out.println("El diccionario está vacío. Añade palabras primero.");
            return;
        }

        int puntos = 0;
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nDefinición: " + palabraAleatoria[1]);
            System.out.print("¿Qué palabra es?: ");
            String respuesta = scanner.nextLine().trim();

            if (juego.verificarRespuesta(palabraAleatoria[0], respuesta)) {
                puntos++;
                System.out.println("¡Correcto! Puntos: " + puntos);
                palabraAleatoria = juego.obtenerPalabraAleatoria();
            } else {
                System.out.println("Incorrecto. La palabra era: " + palabraAleatoria[0]);
                System.out.println("Juego terminado. Puntos totales: " + puntos);
                continuar = false;
            }
        }

        if (juego.esPuntuacionAlta(puntos)) {
            System.out.print("¡Nueva puntuación alta! Ingresa tu nombre: ");
            String nombre = scanner.nextLine().trim();
            juego.agregarPuntuacion(nombre, puntos);
        }
    }

    private static void mostrarPuntuaciones(JuegoDiccionario juego) {
        Map<String, Integer> puntuaciones = juego.obtenerMejoresPuntuaciones();
        if (puntuaciones.isEmpty()) {
            System.out.println("No hay puntuaciones registradas.");
            return;
        }

        System.out.println("\nMEJORES PUNTUACIONES");
        System.out.println("--------------------");
        int posicion = 1;
        for (Map.Entry<String, Integer> entrada : puntuaciones.entrySet()) {
            System.out.println(posicion + ". " + entrada.getKey() + " - " + entrada.getValue() + " puntos");
            posicion++;
        }
    }
}

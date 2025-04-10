package lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MenuConsola {

    private String titulo;
    private List<String> opciones;
    private List<Runnable> acciones;
    private boolean mostrarSalir;

    public MenuConsola(String titulo, boolean mostrarSalir) {
        this.titulo = titulo;
        this.opciones = new ArrayList<>();
        this.acciones = new ArrayList<>();
        this.mostrarSalir = mostrarSalir;
    }

    public void agregarOpcion(String texto, Runnable accion) {
        opciones.add(texto);
        acciones.add(accion);
    }

    public void mostrar() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== " + titulo + " ===");
            for (int i = 0; i < opciones.size(); i++) {
                System.out.println((i + 1) + ". " + opciones.get(i));
            }
            if (mostrarSalir) {
                System.out.println("0. Salir");
            }

            System.out.print("Elige una opción: ");
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido: ");
                sc.next();
            }
            opcion = sc.nextInt();

            if (opcion == 0 && mostrarSalir) {
                System.out.println("saliendo...");
                break;
            } else if (opcion >= 1 && opcion <= acciones.size()) {
                acciones.get(opcion - 1).run();
            } else {
                System.out.println("Opción no válida.");
            }

        } while (true);
    }


    public static void main(String[] args) {
        MenuConsola menu = new MenuConsola("Menú Principal", true);

        menu.agregarOpcion("Saludar", () -> System.out.println("¡Hola! ¿Qué tal?"));
        menu.agregarOpcion("Mostrar fecha", () -> System.out.println("Hoy es " + java.time.LocalDate.now()));
        menu.agregarOpcion("Calcular suma", () -> {

            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce el primer número: ");
            int a = sc.nextInt();
            System.out.print("Introduce el segundo número: ");
            int b = sc.nextInt();
            System.out.println("Resultado: " + (a + b));
        });

        menu.mostrar();
    }
}

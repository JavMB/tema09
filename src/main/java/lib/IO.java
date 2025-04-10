package lib;

import java.util.Scanner;

public class IO {
    private static final Scanner scanner = new Scanner(System.in);

    // Método para leer un entero
    public static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes introducir un número entero válido.");
            }
        }
    }

    // Método para leer un entero dentro de un rango
    public static int readInt(String message, int min, int max) {
        while (true) {
            int num = readInt(message);
            if (num >= min && num <= max) {
                return num;
            }
            System.out.println("Error: El número debe estar entre " + min + " y " + max);
        }
    }

    // Método para leer un double
    public static double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes introducir un número decimal válido.");
            }
        }
    }

    // Método para leer un double dentro de un rango
    public static double readDouble(String message, double min, double max) {
        while (true) {
            double num = readDouble(message);
            if (num >= min && num <= max) {
                return num;
            }
            System.out.println("Error: El número debe estar entre " + min + " y " + max);
        }
    }

    // Método para leer un String
    public static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    // Método para leer un String que no esté vacío
    public static String readNonEmptyString(String message) {
        while (true) {
            String input = readString(message);
            if (!input.trim().isEmpty()) {
                return input;
            }
            System.out.println("Error: No puedes dejar este campo vacío.");
        }
    }

    // Método para leer un char
    public static char readChar(String message) {
        while (true) {
            String input = readString(message);
            if (input.length() == 1) {
                return input.charAt(0);
            }
            System.out.println("Error: Debes introducir exactamente un carácter.");
        }
    }

    // Método para leer un boolean (s/n)
    public static boolean readBoolean(String message) {
        while (true) {
            String input = readString(message + " (s/n): ").toLowerCase();
            if (input.equals("s")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            }
            System.out.println("Error: Debes introducir 's' o 'n'.");
        }
    }


}
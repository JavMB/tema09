package lib;

import java.util.Random;

/**
 * Clase utilitaria para operaciones matemáticas y generación de números aleatorios.
 * Todos los métodos son estáticos para facilitar su uso.
 */
public class Rnd {
    private static final Random random = new Random();

    /**
     * Genera un número entero aleatorio dentro de un rango.
     * @param min Valor mínimo (inclusive)
     * @param max Valor máximo (inclusive)
     * @return Número aleatorio entre min y max
     */
    public static int getInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Genera un número decimal aleatorio dentro de un rango.
     * @param min Valor mínimo (inclusive)
     * @param max Valor máximo (exclusive)
     * @return Número aleatorio entre min y max
     */
    public static double getDouble(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }

    /**
     * Genera un valor booleano aleatorio.
     * @return true o false aleatoriamente
     */
    public static boolean getBoolean() {
        return random.nextBoolean();
    }

    /**
     * Redondea un número a una cantidad específica de decimales.
     * @param value Número a redondear
     * @param decimals Número de decimales deseado
     * @return Valor redondeado
     */
    public static double round(double value, int decimals) {
        double scale = Math.pow(10, decimals);
        return Math.round(value * scale) / scale;
    }

    /**
     * Calcula el factorial de un número.
     * @param n Número para calcular factorial (0-20)
     * @return Factorial de n
     * @throws IllegalArgumentException Si n es negativo o mayor que 20
     */
    public static long factorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("El factorial solo está definido para 0 ≤ n ≤ 20");
        }
        return n == 0 ? 1 : n * factorial(n - 1);
    }

    /**
     * Verifica si un número es primo.
     * @param number Número a verificar
     * @return true si es primo, false si no lo es
     */
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    /**
     * Calcula el máximo común divisor (MCD) de dos números.
     * @param a Primer número
     * @param b Segundo número
     * @return MCD de a y b
     */
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Calcula el mínimo común múltiplo (MCM) de dos números.
     * @param a Primer número
     * @param b Segundo número
     * @return MCM de a y b
     */
    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    /**
     * Genera un número aleatorio con distribución normal (gaussiana).
     * @param mean Media de la distribución
     * @param stdDev Desviación estándar
     * @return Número aleatorio con distribución normal
     */
    public static double getGaussian(double mean, double stdDev) {
        return mean + random.nextGaussian() * stdDev;
    }
}
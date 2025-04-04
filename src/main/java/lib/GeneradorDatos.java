package lib;
import net.datafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class GeneradorDatos {
    private final Faker faker;
    private final Random random;

    // Constructor: inicializa Faker con locale español y un Random para consistencia
    public GeneradorDatos() {
        this.faker = new Faker(new Locale("es", "ES")); // Datos en español
        this.random = new Random();
    }

    // Nombres completos
    public String generarNombreCompleto() {
        return faker.name().fullName();
    }

    // Nombres
    public String generarNombre() {
        return faker.name().firstName();
    }

    // Apellidos
    public String generarApellido() {
        return faker.name().lastName();
    }

    // Fechas de nacimiento (formato dd/MM/yyyy)
    public String generarFechaNacimiento() {
        LocalDate fecha = faker.date().birthday(18, 80).toLocalDateTime().toLocalDate(); // Entre 18 y 80 años
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    // Fechas aleatorias en un rango (formato dd/MM/yyyy)
    public String generarFechaAleatoria(int añoInicio, int añoFin) {
        LocalDate fecha = faker.date().birthday(añoInicio, añoFin).toLocalDateTime().toLocalDate();
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    // Números enteros aleatorios en un rango
    public int generarNumeroEntero(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

    // Números decimales aleatorios en un rango
    public double generarNumeroDecimal(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }

    // Números de teléfono
    public String generarNumeroTelefono() {
        return faker.phoneNumber().phoneNumber();
    }

    // Direcciones completas
    public String generarDireccion() {
        return faker.address().fullAddress();
    }

    // Correos electrónicos
    public String generarCorreoElectronico() {
        return faker.internet().emailAddress();
    }

    // DNI ficticio (8 dígitos + letra)
    public String generarDNI() {
        String numero = String.format("%08d", faker.number().numberBetween(0, 99999999));
        char letra = calcularLetraDNI(numero);
        return numero + letra;
    }

    // calcular la letra del DNI
    private char calcularLetraDNI(String numero) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indice = Integer.parseInt(numero) % 23;
        return letras.charAt(indice);
    }

    // Generar lista de nombres (útil para pruebas masivas)
    public String[] generarListaNombres(int cantidad) {
        String[] nombres = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            nombres[i] = generarNombreCompleto();
        }
        return nombres;
    }



}
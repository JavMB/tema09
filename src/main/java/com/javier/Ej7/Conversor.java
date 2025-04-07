package com.javier.Ej7;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Conversor {
    static HttpClient client = HttpClient.newHttpClient();
    static String apiUrl = "https://v6.exchangerate-api.com/v6/957db40103f687c0f92a4bfb/latest/EUR";
    static HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();


    private final Map<String, Divisa> monedas;

    public Conversor() {
        this.monedas = new HashMap<>();
    }

    /**
     * para llenar los valores mediante la api
     */
    public void llenarMonedas() {
        String codigo;
        double valor;
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            String procesado = json.split("\"conversion_rates\":\\{")[1].split("}")[0];

            String[] conversiones = procesado.split(",");


            for (String moneda : conversiones) {
                codigo = moneda.split(":")[0].replace("\"", "").trim(); // dolor de cabeza
                valor = Double.parseDouble(moneda.split(":")[1]);
                monedas.put(codigo, new Divisa(codigo, valor));

            }


        } catch (Exception e) {
            System.out.println("Fallo en la llamada a la api");

            //(por si falla la API)
            monedas.put("USD", new Divisa("USD", 1.0));
            monedas.put("GBP", new Divisa("GBP", 0.79));
            monedas.put("INR", new Divisa("INR", 83.0));
            monedas.put("AUD", new Divisa("AUD", 1.52));
            monedas.put("CAD", new Divisa("CAD", 1.36));
            monedas.put("ARS", new Divisa("ARS", 820.0));
            monedas.put("BOB", new Divisa("BOB", 6.91));
            monedas.put("CLP", new Divisa("CLP", 920.0));
            monedas.put("COP", new Divisa("COP", 3900.0));
            monedas.put("CRC", new Divisa("CRC", 530.0));
            monedas.put("CUP", new Divisa("CUP", 24.0));
            monedas.put("DOP", new Divisa("DOP", 56.5));
            monedas.put("MXN", new Divisa("MXN", 17.0));
        }
    }

    /**
     *
     * @param cantidadEuros
     * @param moneda
     * @return
     */
    public double convertir(double cantidadEuros, String moneda) {
        if (monedas.containsKey(moneda)) {
            return cantidadEuros * monedas.get(moneda).getValor();
        } else throw new NoSuchElementException("NO ENCONTRADA");

    }


}

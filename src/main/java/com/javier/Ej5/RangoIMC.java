package com.javier.Ej5;

public enum RangoIMC {
    BAJO_PESO(0, 18.5, "Peso insuficiente"),
    NORMAL(18.5, 24.9, "Peso normal"),
    SOBRE_PESO_GRADO_I(25, 26.9, "Sobrepeso grado I"),
    SOBRE_PESO_GRADO_II(27, 29.9, "Sobrepeso grado II"),
    SOBRE_PESO_GRADO_III(30, Double.MAX_VALUE, "Sobrepeso grado III");

    private final double min;
    private final double max;
    private final String mensaje;

    RangoIMC(double min, double max, String mensaje) {
        this.min = min;
        this.max = max;
        this.mensaje = mensaje;
    }

    public boolean estaEnRango(double imc) {
        return imc >= min && imc <= max;
    }

    public String getMensaje() {
        return mensaje;
    }
}
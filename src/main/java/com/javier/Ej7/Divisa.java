package com.javier.Ej7;

public class Divisa {
    private final String codigo;
    private double valor;

    public Divisa(String codigo, double valor) {
        this.codigo = codigo;
        this.valor = valor;
    }


    public String getCodigo() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    // aqui para actualizar o algo la tasa
    private void setValor(double valor) {

    }


}

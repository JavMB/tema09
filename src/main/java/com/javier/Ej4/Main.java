package com.javier.Ej4;

public class Main {
    public static void main(String[] args) {
        Cola<String> cola=new Cola<>();
        cola.add("Primero");
        cola.add("Segundo");
        cola.remove();
        System.out.println(cola);

    }

}

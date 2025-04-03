package com.javier.Ej2;

import java.util.ArrayList;
import java.util.List;

/*
     Crea una clase llamada ArrayListEstadisticas que declare un atributo de tipo ArrayList<Double> y
     que implemente la siguiente interfaz:
     public interface IEstadisticas {
     double minimo();
     double maximo();
     double sumatorio();
     double media();
     double moda();
}
 */
public class Main {

    public static void main(String[] args) {

        List<Double> listita = new ArrayList<>();
        listita.add(5.0);
        listita.add(4.6);
        listita.add(12.6);
        listita.add(255.6);


        ArrayListEstadisticas lista = new ArrayListEstadisticas(listita);

        System.out.println(lista.maximo());


    }
}


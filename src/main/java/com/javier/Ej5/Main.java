package com.javier.Ej5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestionadorPacientes g = new GestionadorPacientes(listaInicial());

        int edadMayor = g.majorMenor(g.pacientes())[1];
        int edadMenor = g.majorMenor(g.pacientes())[0];
        int cantHomb = g.pacientePorSexo(g.pacientes())[0];
        int cantMuj = g.pacientePorSexo(g.pacientes())[1];

        System.out.printf("""
                Paciente mayor edad: %d
                Paciente menor edad: %d
                
                Cantidad de pacientes por sexos:
                Hombres: %d   Mujeres: %d
                """,edadMenor,edadMayor,cantHomb,cantMuj);

        for (Paciente p : g.pacientes()) {
            double imc = g.calcularIMC(p);
            System.out.println("Paciente " + p.getId() + ": " + g.asignarMensajeIMC(imc));
        }

    }


    static List<Paciente> listaInicial() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Paciente> pacientes = new ArrayList<>();

        pacientes.add(new Paciente("María López", LocalDate.parse("12/02/1980", formatter), 'F', 1.63, 57.0));
        pacientes.add(new Paciente("Juan Pérez", LocalDate.parse("07/03/1990", formatter), 'M', 1.74, 60.5));
        pacientes.add(new Paciente("Ana García", LocalDate.parse("20/03/1967", formatter), 'F', 1.62, 50.8));
        pacientes.add(new Paciente("Carlos Ruiz", LocalDate.parse("20/04/1972", formatter), 'M', 1.78, 72.5));
        pacientes.add(new Paciente("Luisa Martínez", LocalDate.parse("29/02/1960", formatter), 'F', 1.80, 85.2));
        return pacientes;
    }


}

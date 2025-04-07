package com.javier.Ej5;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public record GestionadorPacientes(List<Paciente> pacientes) {

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    /**
     * @param pacienteList lista con los pacientes
     * @return devuelve un array de 2 enteros con el menor y mayor paciente
     */
    public int[] majorMenor(List<Paciente> pacienteList) {

        LocalDate edadMayor = pacienteList.get(0).getFechaNac();
        LocalDate edadMenor = pacienteList.get(0).getFechaNac();

        for (Paciente paciente : pacienteList) {
            if (paciente.getFechaNac().isBefore(edadMayor)) {
                edadMayor = paciente.getFechaNac();
            }

            if (paciente.getFechaNac().isAfter(edadMenor)) {
                edadMenor = paciente.getFechaNac();
            }
        }

        int edadMasJoven = Period.between(edadMenor, LocalDate.now()).getYears();
        int edadMasViejo = Period.between(edadMayor, LocalDate.now()).getYears();

        return new int[]{edadMasViejo, edadMasJoven};
    }

    /**
     * @param pacienteList lista con los pacientes
     * @return devuelve un array de 2 enteros con el numero de hombres y mujeres
     */
    public int[] pacientePorSexo(List<Paciente> pacienteList) {
        int cantidadMujeres = 0;
        int cantidadHombres = 0;

        for (Paciente paciente : pacienteList) {
            if (paciente.getSexo() == 'M') {
                cantidadHombres++;
            } else {
                cantidadMujeres++;
            }
        }

        return new int[]{cantidadHombres, cantidadMujeres};
    }

    public double calcularIMC(Paciente paciente) {
        return paciente.getPeso() / Math.pow(paciente.getAltural(), 2);
    }

    public String asignarMensajeIMC(double imc) {
        for (RangoIMC rango : RangoIMC.values()) {
            if (rango.estaEnRango(imc)) {
                return rango.getMensaje();
            }
        }
        return "IMC fuera de los rangos esperados";
    }
}

package com.javier.Ej10;

import java.util.List;

public class Empleado {
    private String nif;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private double sueldo;
    private List<Hijo> hijos; // Lista de hijos de este empleado

    public Empleado(String nif, String nombre, String apellidos, String fechaNacimiento, double sueldo) {

    }



    public void agregarHijo(Hijo hijo) {
        // agregar un hijo a la lista
    }

    public void borrarHijo(String nombreHijo) {
        // eliminar un hijo por nombre
    }

    public boolean tieneHijosMenoresDeEdad() {
        // comprobar si tiene hijos menores de edad
        return false; // Este es solo un ejemplo
    }


}

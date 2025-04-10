package com.javier.Ej11;

import com.javier.Ej11.entidades.Alumno;
import com.javier.Ej11.servicios.Centro;
import lib.GeneradorDatos;
import lib.IO;
import lib.MenuConsola;

public class Main {
    private final static Centro c = new Centro();

    public static void main(String[] args) {
        generarDatosDePrueba();
        MenuConsola menuPrincipal = new MenuConsola("Gestión de Alumnos", true);

        menuPrincipal.agregarOpcion("Dar de altas", Main::mostrarSubmenuAltas);
        menuPrincipal.agregarOpcion("Consultas", Main::mostrarSubmenuConsultas);


        menuPrincipal.mostrar();


    }

    public static void altaAlumno() {
        String nombre = IO.readString("Dime el nombre del alumno");
        int grupo = IO.readInt("Dime el id del grupo");

        if (c.addAlumno(nombre, grupo)) {
            System.out.println("Alumno dado de alta exitosamente");
        } else {
            System.out.println("Alumno no dado de alta , revisa si el grupo existe");
        }

    }

    public static void altaGrupo() {
        String nombre = IO.readString("Dime el nombre del grupo");
        int aula = IO.readInt("Dime el id del aula");

        if (c.addGrupo(nombre, aula)) {
            System.out.println("Grupo dado de alta exitosamente");
        } else {
            System.out.println("Grupo no dado de alta , revisa si el aula existe");
        }

    }

    public static void altaAula() {
        int m2 = IO.readInt("Dime cuantos m2 tiene");
        c.addAula(m2);
        System.out.println("Aula dada de alta exitosamente");
    }

    public static void altaProfesor() {
        String nombre = IO.readString("Dime el nombre");
        String dni = IO.readString("Dime el dni: ");


        if (c.addProfesor(dni, nombre)) {
            System.out.println("Profesor dado de alta exitosamente");
        } else {
            System.out.println("Profesor no dado de alta, ya existe!");
        }


    }

    private static void altaAsignatura() {
        String nombre = IO.readString("Dime el nombre");
        String dni = IO.readString("Dime el dni del profesor que la impartira");

        if (c.addAsignatura(nombre, dni)) {
            System.out.println("Asignatura creada con exito");
        } else {
            System.out.println("Asignatura no creada, revisa si ese profesor esta disponible");
        }


    }


    public static void mostrarSubmenuAltas() {

        MenuConsola menuAltas = new MenuConsola("Altas", true);
        menuAltas.agregarOpcion("Alta alumno", Main::altaAlumno);
        menuAltas.agregarOpcion("Alta grupo", Main::altaGrupo);
        menuAltas.agregarOpcion("Alta aula", Main::altaAula);
        menuAltas.agregarOpcion("Alta profesor", Main::altaProfesor);
        menuAltas.agregarOpcion("Alta asignatura", Main::altaAsignatura);


        menuAltas.mostrar();
    }


    public static void mostrarSubmenuConsultas() {
        MenuConsola menuConsultas = new MenuConsola("Consultas", true);
        menuConsultas.agregarOpcion("Consulta por id Alumno: ", Main::consultaAlumno);
//        menuConsultas.agregarOpcion("IN");


        menuConsultas.mostrar();
    }

    public static void consultaAlumno() {
        int idAlumno = IO.readInt("Dime el id del alumno");

        Alumno alumno = c.getAlumnoPorId(idAlumno);

        if (alumno != null) {
            System.out.println(alumno);
        } else {
            System.out.println("Alumno no encontrado");
        }
    }


    public static void generarDatosDePrueba() {
        GeneradorDatos generador = new GeneradorDatos();

        // Crear Aulas
        System.out.println("Creando aulas...");
        for (int i = 1; i <= 3; i++) {
            int m2 = generador.generarNumeroEntero(30, 100);
            c.addAula(m2);
        }

        // Crear Grupos
        System.out.println("Creando grupos...");
        for (int i = 1; i <= 3; i++) {
            String nombreGrupo = "Grupo " + i;
            int aulaId = generador.generarNumeroEntero(1, 3);
            c.addGrupo(nombreGrupo, aulaId);
        }

        // Crear Profesores
        System.out.println("Creando profesores...");
        for (int i = 1; i <= 3; i++) {
            String nombreProfesor = generador.generarNombreCompleto();
            String dniProfesor = generador.generarDNI();
            c.addProfesor(dniProfesor, nombreProfesor);
        }

        // Crear Alumnos
        System.out.println("Creando alumnos...");
        for (int i = 1; i <= 10; i++) {
            String nombreAlumno = generador.generarNombreCompleto();
            int grupoId = generador.generarNumeroEntero(1, 3);
            c.addAlumno(nombreAlumno, grupoId);
        }

        System.out.println("Datos generados con éxito.");
    }


}

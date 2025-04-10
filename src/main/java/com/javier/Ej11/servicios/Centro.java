package com.javier.Ej11.servicios;

import com.javier.Ej11.entidades.*;


public class Centro {
    private final Gestionable<Alumno, Integer> alumnos;
    private final Gestionable<Asignatura, Integer> asignaturas;
    private final Gestionable<Aula, Integer> aulas;
    private final Gestionable<Grupo, Integer> grupos;
    private final Gestionable<Profesor, String> profesores;

    public Centro() {
        alumnos = new AlumnoService();
        asignaturas = new AsignaturaService();
        aulas = new AulasService();
        grupos = new GrupoService();
        profesores = new ProfesorService();
    }

    public boolean addAlumno(String nombre, int grupoId) {
        Grupo grupo = getGrupoPorId(grupoId);

        if (grupo != null) {
            alumnos.add(new Alumno(nombre, grupo));
            return true;
        }

        return false;
    }

    public boolean addGrupo(String nombre, int aulaId) {
        Aula aula = getAulaPorId(aulaId);

        if (aula != null) {
            grupos.add(new Grupo(nombre, aula));
            return true;
        }

        return false;
    }

    public void addAula(int m2) {
        aulas.add(new Aula(m2));
    }

    public boolean addProfesor(String dni, String nombre) {
        Profesor prof = profesores.get(dni);

        if (prof == null) {
            profesores.add(new Profesor(dni, nombre));
            return true;
        } else return false;


    }

    public boolean addAsignatura(String nombre, String dniProfesor) {

        Profesor prof = profesores.get(dniProfesor);

        if (prof != null) {
            asignaturas.add(new Asignatura(nombre, prof));
            return true;
        }
        return false;


    }


    public Profesor getProfesorPorId(String dni) {
        return profesores.get(dni);
    }


    public Grupo getGrupoPorId(int id) {
        return grupos.get(id);
    }

    public Aula getAulaPorId(int aulaId) {
        return aulas.get(aulaId);
    }

    public Alumno getAlumnoPorId(int alumnoId) {
        return alumnos.get(alumnoId);

    }

    public Asignatura getAsinaturaPorId(int asignaturaId) {
        return asignaturas.get(asignaturaId);

    }


}


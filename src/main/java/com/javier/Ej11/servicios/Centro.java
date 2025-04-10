package com.javier.Ej11.servicios;

import com.javier.Ej11.entidades.*;
import com.javier.Ej11.excepciones.*;

import java.util.List;

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
        Grupo grupo = grupos.get(grupoId);
        if (grupo == null) {
            throw new EntidadNoEncontradaException("Grupo", grupoId);
        }
        alumnos.add(new Alumno(nombre, grupo));
        return true;
    }

    public boolean addGrupo(String nombre, int aulaId) {
        Aula aula = aulas.get(aulaId);
        if (aula == null) {
            throw new EntidadNoEncontradaException("Aula", aulaId);
        }
        grupos.add(new Grupo(nombre, aula));
        return true;
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
        if (prof == null) {
            throw new EntidadNoEncontradaException("Profesor", dniProfesor);
        }
        asignaturas.add(new Asignatura(nombre, prof));
        return true;
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

    public Asignatura getAsignaturaPorId(int asignaturaId) {
        return asignaturas.get(asignaturaId);
    }

    public boolean matricularAlumnoEnAsignatura(int asignaturaId, int alumnoId) {
        if (asignaturaId < 0 || alumnoId < 0) {
            throw new IllegalArgumentException("Los IDs no pueden ser negativos");
        }

        Alumno alumno = alumnos.get(alumnoId);
        if (alumno == null) {
            throw new EntidadNoEncontradaException("Alumno", alumnoId);
        }

        Asignatura asignatura = asignaturas.get(asignaturaId);
        if (asignatura == null) {
            throw new EntidadNoEncontradaException("Asignatura", asignaturaId);
        }

        List<Asignatura> asignaturasAlumno = alumno.getAsignaturas();

        if (asignaturasAlumno.contains(asignatura)) {
            throw new MatriculaException("El alumno ya está matriculado en esta asignatura");
        }

        asignaturasAlumno.add(asignatura);
        return true;
    }
}


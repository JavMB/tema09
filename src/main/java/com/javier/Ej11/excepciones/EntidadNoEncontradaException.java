package com.javier.Ej11.excepciones;

public class EntidadNoEncontradaException extends CentroException {
    public EntidadNoEncontradaException(String entidad, Object id) {
        super(String.format("%s con ID %s no encontrado/a", entidad, id));
    }
}
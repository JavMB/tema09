package com.javier.Ej3;

/*
Escribe una clase llamada Pila que implemente la estructura Pila que vimos en el anexo II del tema
7, pero en esta ocasión utilizando estructuras dinámicas (ArrayList). Para llevar a cabo la
implementación de esta clase tendrás que definir en primer lugar la siguiente interfaz que declara
las operaciones básicas de una Pila:
public interface IPila<T> {
T push(T e);
T pop();
int size();
T top();
boolean isEmpty();
}
y posteriormente implementar esa interfaz en la clase Pila.
Después, desde la clase principal crea un objeto de tipo Pila, añade algunos valores aleatorios,
borra otros y finalmente muestra el contenido de la Pila.
Reflexión:
Examina la clase Stack del paquete java.util, observa sus métodos y compáralos con los que has
definido en la clase Pila.
 */
public class Main {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();
        pila.push(5);
        pila.push(6);
        pila.pop();
        System.out.println(pila);
    }
}

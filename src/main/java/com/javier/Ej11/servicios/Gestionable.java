package com.javier.Ej11.servicios;

 interface Gestionable<T,K> {
    void add(T dato);
    T get(K clave);
}

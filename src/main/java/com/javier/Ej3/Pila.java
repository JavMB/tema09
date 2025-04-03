package com.javier.Ej3;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Pila<T> implements IPila<T> {
    private final List<T> data;

    public Pila() {
        data = new ArrayList<>();
    }

    @Override
    public T push(T e) {
        data.add(e);
        return e;
    }

    @Override
    public T pop() {
        return data.remove(data.size() - 1);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public T top() {
        return data.get(data.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pila.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .toString();
    }
}

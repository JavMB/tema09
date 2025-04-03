package com.javier.Ej4;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Cola<T> implements ICola<T> {
    private final List<T> data;

    public Cola() {
        this.data = new ArrayList<>();
    }

    @Override
    public boolean add(T e) {
        return data.add(e);
    }

    @Override
    public T remove() {
        return data.remove(0);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public T peek() {
        return data.get(0);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cola.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .toString();
    }
}

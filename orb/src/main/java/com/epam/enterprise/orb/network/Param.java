package com.epam.enterprise.orb.network;

/**
 * Created by Aleh_Atsman on 2/10/2015.
 */
public class Param<T> {

    private T value;
    private String className;

    public Param(T value, String className) {
        this.value = value;
        this.className = className;
    }

    public T getValue() {
        return value;
    }

    public String getClassName() {
        return className;
    }
}

package com.epam.enterprise.orb;

/**
 * Created by Aleh_Atsman on 2/10/2015.
 */
public class Callee implements Calculator {

    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }

}

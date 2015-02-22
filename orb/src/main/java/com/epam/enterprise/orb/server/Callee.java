package com.epam.enterprise.orb.server;

import com.epam.enterprise.orb.Calculator;

/**
 * Created by Aleh_Atsman on 2/10/2015.
 */
public class Callee implements Calculator {

    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }

}

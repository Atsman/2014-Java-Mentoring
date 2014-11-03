package com.epam.mentoring.junit.calculator;

import org.junit.Test;

/**
 * Created by alehatsman on 11/3/14.
 */
public class DivNegTest extends AbstractFuncTest{

    @Test(expected= IllegalArgumentException.class)
    public void dividingByZero() {
        calculator.div(4, 0);
    }

}

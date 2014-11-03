package com.epam.mentoring.junit.calculator;

import org.junit.Before;

/**
 * Created by alehatsman on 11/3/14.
 */
public abstract class AbstractFuncTest {

    protected Calculator calculator;

    @Before
    public void createCalc() {
        calculator = new Calculator();
    }

}

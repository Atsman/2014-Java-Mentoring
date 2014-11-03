package com.epam.mentoring.junit.calculator;

import org.junit.Test;

/**
 * Created by alehatsman on 11/3/14.
 */
public class RootNegTest extends AbstractFuncTest {

    @Test(expected = IllegalArgumentException.class)
    public void simple() {
        calculator.root(-5);
    }

}

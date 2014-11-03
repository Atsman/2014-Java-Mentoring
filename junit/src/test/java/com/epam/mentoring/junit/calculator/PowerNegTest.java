package com.epam.mentoring.junit.calculator;

import org.junit.Test;

import static  org.junit.Assert.*;

/**
 * Created by alehatsman on 11/3/14.
 */
public class PowerNegTest extends AbstractFuncTest {

    @Test(expected = IllegalArgumentException.class)
    public void test() {
        calculator.power(-3, 1/2);
    }

}

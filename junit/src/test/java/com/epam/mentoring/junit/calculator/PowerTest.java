package com.epam.mentoring.junit.calculator;

import org.junit.Test;

import static  org.junit.Assert.*;

/**
 * Created by alehatsman on 11/3/14.
 */
public class PowerTest extends AbstractFuncTest {

    @Test
    public void test() {
        assertTrue(calculator.power(2, 3) == 8);
        assertTrue(calculator.power(3, 2) == 9);
    }

}

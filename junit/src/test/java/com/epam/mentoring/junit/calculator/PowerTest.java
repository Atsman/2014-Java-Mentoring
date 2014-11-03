package com.epam.mentoring.junit.calculator;

import org.junit.Test;

import static  org.junit.Assert.*;

/**
 * Created by alehatsman on 11/3/14.
 */
public class PowerTest extends AbstractFuncTest {

    @Test
    public void test() {
        assertEquals(8, calculator.power(2, 3), 0);
        assertEquals(9, calculator.power(3, 2), 0);
        assertEquals(9, calculator.power(-3, 2), 0);
        assertEquals(3, calculator.power(9, 0.5), 0);
    }

}

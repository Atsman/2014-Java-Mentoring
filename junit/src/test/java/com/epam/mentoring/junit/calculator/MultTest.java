package com.epam.mentoring.junit.calculator;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by alehatsman on 11/3/14.
 */
public class MultTest extends AbstractFuncTest {

    @Test
    public void simple() {
        assertTrue(calculator.mult(2, 3) == 6);
        assertTrue(calculator.mult(3, 2) == 6);
        assertTrue(calculator.mult(3, 3) == 9);
        assertTrue(calculator.mult(-2, -3) == 6);
    }

}

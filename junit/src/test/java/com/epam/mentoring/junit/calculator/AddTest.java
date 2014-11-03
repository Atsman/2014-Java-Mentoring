package com.epam.mentoring.junit.calculator;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by alehatsman on 11/3/14.
 */
public class AddTest extends AbstractFuncTest{

    @Test
    public void simple() {
        assertTrue("2 + 3 = 5", calculator.add(2, 3) == 5);
        assertTrue("2 + 4 = 6", calculator.add(2, 4) == 6);
        assertTrue("-25 + 4 = -21", calculator.add(-25, 4) == -21);
    }

}

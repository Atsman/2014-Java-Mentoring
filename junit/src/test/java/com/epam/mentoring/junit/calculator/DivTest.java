package com.epam.mentoring.junit.calculator;

import static  org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by alehatsman on 11/3/14.
 */

public class DivTest extends AbstractFuncTest {

    @Test
    public void simple() {
        assertTrue("4 / 2 = 2", calculator.div(4, 2) == 2);
        assertTrue("9 / 3 = 3", calculator.div(9, 3) == 3);
        assertTrue("-21 / 3 = -7", calculator.div(-21, 3) == -7);
    }

}

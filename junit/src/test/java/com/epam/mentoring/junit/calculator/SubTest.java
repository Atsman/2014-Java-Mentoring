package com.epam.mentoring.junit.calculator;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by alehatsman on 11/3/14.
 */
public class SubTest extends AbstractFuncTest {

    @Test
    public void simple() {
        assertTrue("2 - 5 = -3", calculator.sub(2, 5) == -3);
    }
}

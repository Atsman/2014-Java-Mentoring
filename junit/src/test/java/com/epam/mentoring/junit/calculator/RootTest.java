package com.epam.mentoring.junit.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by alehatsman on 11/3/14.
 */
public class RootTest extends AbstractFuncTest {

    @Test
    public void test() {
        assertTrue(calculator.root(9) == 3);
        assertTrue(calculator.root(81) == 9);
    }

}

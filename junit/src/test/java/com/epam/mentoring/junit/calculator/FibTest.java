package com.epam.mentoring.junit.calculator;

import org.junit.Test;
import static  org.junit.Assert.*;

/**
 * Created by alehatsman on 11/3/14.
 */
public class FibTest extends AbstractFuncTest {

    @Test
    public void test() {
        assertTrue(calculator.fib(1) == 1);
        assertTrue(calculator.fib(2) == 1);
        assertTrue(calculator.fib(3) == 2);
    }

}

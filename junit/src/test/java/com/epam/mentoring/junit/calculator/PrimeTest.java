package com.epam.mentoring.junit.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alehatsman on 11/3/14.
 */
public class PrimeTest extends AbstractFuncTest {

    @Test
    public void test() {
        assertFalse(calculator.isPrime(6));
        assertTrue(calculator.isPrime(5));
        assertTrue(calculator.isPrime(93563));
        assertFalse(calculator.isPrime(121));
    }

}

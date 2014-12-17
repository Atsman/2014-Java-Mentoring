package com.epam.mentoring.junit.calculator;

import org.junit.Test;

import static  org.junit.Assert.*;

/**
 * Created by alehatsman on 11/3/14.
 */
public class PrimeNegTest extends AbstractFuncTest {

    @Test(timeout=1000, expected = Exception.class)
    public void timeout() {
        calculator.isPrime(5600748293801L);
    }

}

package com.epam.mentoring.junit.calculator;

import org.junit.Test;

/**
 * Created by alehatsman on 11/3/14.
 */
public class PrimeNegTest extends AbstractFuncTest {

    @Test(timeout=1000)
    public void timeout() {
        long t1 = System.currentTimeMillis();
        calculator.isPrime(5600748293801L);
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

}

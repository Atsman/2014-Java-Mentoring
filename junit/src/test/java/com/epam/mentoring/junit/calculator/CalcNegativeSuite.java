package com.epam.mentoring.junit.calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by alehatsman on 11/3/14.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    DivNegTest.class,
    RootNegTest.class,
    PrimeNegTest.class,
    PowerNegTest.class
})
public class CalcNegativeSuite {
}

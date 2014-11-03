package com.epam.mentoring.junit.calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by alehatsman on 11/3/14.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
    AddTest.class,
    DivTest.class,
    MultTest.class,
    SubTest.class,
    FibTest.class,
    RootTest.class,
    PrimeTest.class
})
public class CalcPositiveSuite {
}

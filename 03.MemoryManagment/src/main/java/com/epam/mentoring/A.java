package com.epam.mentoring;

/**
 * Created by Aleh_Atsman on 10/15/2014.
 */
public class A {
    private A a;
    A() {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a = new A();
    }
}

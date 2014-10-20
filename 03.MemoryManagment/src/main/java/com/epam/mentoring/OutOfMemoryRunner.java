package com.epam.mentoring;

/**
 * Created by Aleh_Atsman on 10/15/2014.
 */
public class OutOfMemoryRunner {

    public static void main(String args[]) throws InterruptedException {
        B b = new B();
        B prev = new B();
        prev.setB(b);
        while (true) {
            B cur = new B();
            cur.setB(prev);
            prev = cur;
            Thread.sleep(1L);
        }
    }

}

package com.epam.mentoring;

/**
 * Created by Aleh_Atsman on 10/15/2014.
 */
public class OutOfMemoryRunner {

    public static void main(String args[]) {
        B b = new B();
        B prev = new B();
        prev.b = b;
        while (true) {
            B cur = new B();
            cur.b = prev;
            prev = cur;
        }
    }

}

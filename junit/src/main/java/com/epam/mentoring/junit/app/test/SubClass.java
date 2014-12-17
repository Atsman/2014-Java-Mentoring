package com.epam.mentoring.junit.app.test;

/**
 * Created by Aleh_Atsman on 11/12/2014.
 */
public class SubClass extends SuperClass {

    public static void printMe() throws ArithmeticException {
        System.out.println("Sub");
    }

    public static void main(String args[]) {
        SuperClass sc = new SubClass();
        sc.printMe();
        System.out.printf("12%1$s", "13%1$s", "14%1$s");
    }

}

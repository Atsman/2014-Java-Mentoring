package com.epam.mentoring.junit.calculator;

/**
 * Created by alehatsman on 11/3/14.
 */
public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mult(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        if(b == 0) {
            throw new IllegalArgumentException("Dividing by zero");
        }
        return a / b;
    }

    public double root(double a) {
        if(a < 0) {
            throw new IllegalArgumentException("a < 0");
        }
        return Math.sqrt(a);
    }

    public double power(double a, double b) {
        if(a < 0 && b < 1) {
            throw new IllegalArgumentException("a < 0 || b < 1");
        }
        return Math.pow(a, b);
    }

    boolean isPrime(long n) {
        if (n%2==0) return false;
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }

    public long fib(long n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }

}

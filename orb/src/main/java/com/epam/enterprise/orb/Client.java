package com.epam.enterprise.orb;

/**
 * Created by Aleh_Atsman on 2/10/2015.
 */
public class Client {

    public static void main(String[] args) {
        Calculator calculator = new Stub();
        Double res = calculator.add(10.0, 20.0);
        System.out.println(res);
    }

}

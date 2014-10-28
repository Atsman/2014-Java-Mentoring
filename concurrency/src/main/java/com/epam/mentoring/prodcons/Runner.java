package com.epam.mentoring.prodcons;

/**
 * Created by alehatsman on 10/26/14.
 */
public class Runner {

    public static void main(String[] args) {
        Queue queue = new Queue(10);
        new Producer(queue, "P1");
        new Producer(queue, "P2");
        new Consumer(queue, "C1");
        new Consumer(queue, "C2");
        new Consumer(queue, "C3");
    }

}

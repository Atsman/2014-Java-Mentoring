package com.epam.mentoring.prodcons;

/**
 * Created by alehatsman on 10/26/14.
 */
public class Runner {

    public static void main(String[] args) {
        Queue queue = new Queue();
        new Producer(queue);
        new Consumer(queue);
    }

}

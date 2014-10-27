package com.epam.mentoring.prodcons;

/**
 * Created by alehatsman on 10/26/14.
 */
public class Consumer implements Runnable {

    private Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while(true) {
            queue.get();
        }
    }
}

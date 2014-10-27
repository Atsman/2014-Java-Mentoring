package com.epam.mentoring.prodcons;

/**
 * Created by alehatsman on 10/26/14.
 */
public class Producer implements Runnable {

    private Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        Integer i = 0;
        while(true) {
            queue.put(i++);
        }
    }

}

package com.epam.mentoring.prodcons;

import org.apache.log4j.Logger;

import java.util.Random;

/**
 * Created by alehatsman on 10/26/14.
 */
public class Producer implements Runnable {

    private Logger log = Logger.getLogger(getClass());
    private Random random = new Random();

    private Queue queue;
    private String name;

    public Producer(Queue queue, String name) {
        this.queue = queue;
        this.name = name;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        Integer i = 0;
        while(true) {
            try {
                i = i + 1;
                queue.put(i);
                log.info(name + " put :" + i);
                sleep();
            } catch (FullQueueException fullQueueExceprion) {
                sleep();
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(random.nextInt(150));
        } catch (InterruptedException e) {
            log.error("Producer - sleep", e);
        }
    }

}

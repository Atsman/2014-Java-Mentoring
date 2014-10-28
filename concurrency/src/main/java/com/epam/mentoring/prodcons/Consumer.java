package com.epam.mentoring.prodcons;

import org.apache.log4j.Logger;

import java.util.Random;

/**
 * Created by alehatsman on 10/26/14.
 */
public class Consumer implements Runnable {

    private Logger log = Logger.getLogger(getClass());
    private Random random = new Random();

    private Queue queue;
    private String name;

    public Consumer(Queue queue, String name) {
        this.queue = queue;
        this.name = name;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        while(true) {
            try {
                Object o = queue.get();
                if(o != null) {
                    log.info(name + " get :" + o);
                }
                Thread.sleep(random.nextInt(150));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

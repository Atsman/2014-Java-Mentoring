package com.epam.mentoring.prodcons;

import org.apache.log4j.Logger;

/**
 * Created by alehatsman on 10/26/14.
 */
public class Queue {

    private Logger log = Logger.getLogger(getClass());

    private Object message;
    private boolean isFull = false;

    public synchronized Object get() {
        while(!isFull) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.info("InterruptedException", e);
            }
        }
        log.info("Got " + message);
        isFull = false;
        notify();
        return message;
    }

    public synchronized void put(Object message) {
        while(isFull) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.info("InterruptedException", e);
            }
        }

        this.message = message;
        isFull = true;
        log.info("Put " + message);
        notify();
    }

}

package com.epam.mentoring.parallelthreads;

import org.apache.log4j.Logger;

import java.util.Observable;

/**
 * Created by alehatsman on 10/26/14.
 */
public class Car extends Observable implements Runnable {

    public static final String FINISHED = "FINISHED";
    public static final String DISQUALIFIED = "DISQUALIFIED";

    private static final long MAX_DISTANCE = 10000;

    Logger log = Logger.getLogger(getClass());

    private long friction;
    private long distance;

    private String name;

    public Car(String name, long friction) {
        this.name = name;
        this.friction = friction;
    }

    @Override
    public void run() {
        try {
            while (distance < MAX_DISTANCE) {
                Thread.sleep(friction);
                distance += 100;
                log.info(name + " " + distance);
            }
            setChanged();
            notifyObservers(FINISHED);
        } catch (InterruptedException e) {
            setChanged();
            notifyObservers(DISQUALIFIED);
        }
    }

    public String getName() {
        return name;
    }

}
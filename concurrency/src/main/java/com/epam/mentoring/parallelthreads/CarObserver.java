package com.epam.mentoring.parallelthreads;

import org.apache.log4j.Logger;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by alehatsman on 10/26/14.
 */
public class CarObserver implements Observer {

    Logger log = Logger.getLogger(getClass());

    private int place = 0;

    @Override
    public void update(Observable o, Object arg) {
        Car car = (Car)o;
        switch ((String)arg) {
            case Car.FINISHED:
                place += 1;
                if(place == 1) {
                    log.info("Winner is " + car.getName());
                } else {
                    log.info(place + "'th place is " + car.getName());
                } break;

            case Car.DISQUALIFIED:
                log.info("Disqualified car " + car.getName()); break;

            default: throw new IllegalArgumentException("Not expected constant");
        }
    }

}

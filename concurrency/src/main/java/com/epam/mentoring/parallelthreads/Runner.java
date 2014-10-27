package com.epam.mentoring.parallelthreads;

import java.util.Random;

/**
 * Created by alehatsman on 10/26/14.
 */
public class Runner {

    private static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        CarObserver carObserver = new CarObserver();

        Thread[] cars = new Thread[] {
            createCar(carObserver, "Car1", 200),
            createCar(carObserver, "Car2", 180),
            createCar(carObserver, "Car3", 190),
            createCar(carObserver, "Car4", 201),
            createCar(carObserver, "Car5", 187)
        };

        for(Thread car : cars) {
            car.start();
        }

        Thread.sleep(5000);
        int randomCarNumber = getRandomNumber(cars.length);
        cars[randomCarNumber].interrupt();
    }

    public static Thread createCar(CarObserver carObserver, String name, long friction) {
        Car car = new Car(name, friction);
        car.addObserver(carObserver);
        return new Thread(car);
    }

    public static int getRandomNumber(int n) {
        return random.nextInt(n);
    }
}

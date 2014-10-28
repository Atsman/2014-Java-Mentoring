package com.epam.mentoring.prodcons;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alehatsman on 10/26/14.
 */
public class Queue {

    private List<Object> queue = new LinkedList<>();
    private int  limit = 10;

    public Queue(int limit){
        this.limit = limit;
    }

    public synchronized Object get() {
        if(this.queue.size() == 0){
            return null;
        }
        return this.queue.remove(0);
    }

    public synchronized void put(Object message) throws FullQueueException {
        while(this.queue.size() == this.limit) {
            throw new FullQueueException("Queue is full");
        }
        this.queue.add(message);
    }

}

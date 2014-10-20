package com.epam.mentoring.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alehatsman on 10/11/14.
 */
class HeapSpace {

    public static void main(String[] args) {
        List<Object> l = new ArrayList<Object>();

        while(true) {
            l.add(new Object());
        }
    }

}

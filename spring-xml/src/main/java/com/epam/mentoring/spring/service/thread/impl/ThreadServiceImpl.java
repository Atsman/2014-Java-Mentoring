package com.epam.mentoring.spring.service.thread.impl;

import com.epam.mentoring.spring.service.thread.ThreadService;

/**
 * Created by alehatsman on 12/20/14.
 */
public class ThreadServiceImpl implements ThreadService {

    private String msg = "Default";

    @Override
    public void doSmth() {
        System.out.println(msg);
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }
}
